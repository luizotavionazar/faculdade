document.addEventListener('DOMContentLoaded', () => {

    //--------------------TEMA----------------------
    const toggleButton = document.getElementById('themeToggle');
    const themeIcon = document.querySelector('.icone-tema');
    const currentTheme = localStorage.getItem('theme') || 'light';

    document.documentElement.setAttribute('data-theme', currentTheme);

    function updateIcon(theme) { // Função para atualizar o ícone do tema realziando animação
        themeIcon.classList.remove('expandir');
        themeIcon.classList.add('encolher');

        setTimeout(() => {
            themeIcon.classList.remove('encolher');

            if (theme === 'dark') { // Alterna entre os ícones de sol e lua
                themeIcon.classList.remove('fa-moon');
                themeIcon.classList.add('fa-sun');
            } else {
                themeIcon.classList.remove('fa-sun');
                themeIcon.classList.add('fa-moon');
            }
        }, 100);
    }

    updateIcon(currentTheme); // Define o ícone inicial

    toggleButton.addEventListener('click', function (event) { // Alterna o tema e icone ao clicar no botão, gravando em localStorage
        event.preventDefault();
        let theme = document.documentElement.getAttribute('data-theme') === 'light' ? 'dark' : 'light';
        document.documentElement.setAttribute('data-theme', theme);
        localStorage.setItem('theme', theme);
        updateIcon(theme);
    });
    //--------------------TEMA----------------------

    //--------------------SEÇÂO E BOTÃO ATIVO----------------------
    const botoes = document.querySelectorAll('.menu-button');
    const secoes = document.querySelectorAll('.content-section');
    const portfolioSubmenu = document.getElementById('portfolioSubmenu');
    const menu = document.querySelector('.menu-container');

    function ativarMenu(secaoId) { // Função para exibir o conteudo da seção clicada e ativar o botão clicado
        secoes.forEach(section => section.classList.remove('active')); // Para exibir apenas o conteudo da seção clicada
        botoes.forEach(button => button.classList.remove('active')); // Para apenas o botão clicado ficar ativo

        const secaoAgora = document.getElementById(secaoId);
        const botaoAgora = document.querySelector(`[data-section="${secaoId}"]`);

        if (secaoAgora && botaoAgora) { // Ativa a seção e o botão clicado
            secaoAgora.classList.add('active');
            botaoAgora.classList.add('active');
        }

        if (secaoId !== 'portfolio') { // Fechar submenu ao trocar de seção
            portfolioSubmenu.classList.remove('show');
        } else { 
            // Aqui - colocar codigo para ativar o botão portifolio para garantir que ele mudará de cor ao acessar uma opção do submenu
        }
    }

    botoes.forEach(button => { // Em dispositivo movel, oculta o menu ao clicar em um botão
        button.addEventListener('click', () => {
            const secaoId = button.dataset.section;

            ativarMenu(secaoId);

            if (window.innerWidth < 768 && secaoId !== 'portfolio') {
                menu.classList.add('hide');

                setTimeout(() => {
                    menu.classList.remove('show', 'hide');
                }, 300); // Tempo igual à duração da transição
            }

            setbotaoAgora();
        });
    });

    const iconMenu = document.getElementById('iconMenu');
    const iconeMenu = document.querySelector('.icone-menu');
    const menubotoes = document.querySelectorAll('.menu-button');

    function animaIconMenu() { // Animação do ícone do menu em dispositivos móveis
        menubotoes.forEach((button, index) => {
            button.style.opacity = '0'; //ajustar para chamar so 1 CSS
            button.style.transform = 'translateX(-20px)';
            setTimeout(() => {
                button.style.opacity = '1';
                button.style.transform = 'translateX(0)';
            }, index * 150);
        });
    }
    //--------------------SEÇÂO E BOTÃO ATIVO----------------------

    //--------------------MENU----------------------
    // Fecha o menu ao clicar em um botão e atualiza o icone Em dispositivo móvel
    iconMenu.addEventListener('click', () => {
        const menuEstaAberto = menu.classList.contains('show');
            
        if (menu.classList.contains('show')) { // Abre e fecha o menu
            menu.classList.remove('show');
            menu.classList.add('hide');
        } else {
            menu.classList.remove('hide');
            menu.classList.add('show');
            animaIconMenu();
        }
    
        if (window.innerWidth < 768) { //Atualiza o icone do menu
            if (menuEstaAberto) {
                // Menu estava aberto e agora está fechado: ícone deve ser "down"
                iconeMenu.classList.remove('fa-caret-up');
                iconeMenu.classList.add('fa-caret-down');
            } else {
                // Menu estava fechado e agora está aberto: ícone deve ser "up"
                iconeMenu.classList.remove('fa-caret-down');
                iconeMenu.classList.add('fa-caret-up');
            }
        }
    });
    //--------------------MENU----------------------

    //--------------------ANIMAÇÃO----------------------
    const portfolioBtn = document.getElementById('portfolioBtn');
    const submenubotoes = document.querySelectorAll('.submenu-button');
    let keepOpen = false;

    function animateSubmenuItems() { // Função para animar os itens do submenu
        submenubotoes.forEach((button, index) => {
            button.style.opacity = '0';
            button.style.transform = 'translateX(-20px)';
            setTimeout(() => {
                button.style.opacity = '1';
                button.style.transform = 'translateX(0)';
            }, index * 200);
        });
    }

    portfolioBtn.addEventListener('mouseenter', () => { // Animação do submenu ao passar o mouse
        if (!portfolioSubmenu.classList.contains('show')) {
            portfolioSubmenu.classList.add('show');
            animateSubmenuItems();
        }
    });

    document.querySelectorAll('.menu-button').forEach(button => {
        button.addEventListener('click', () => {
            if (button.dataset.section !== 'portfolio') {
                keepOpen = false;
                portfolioSubmenu.classList.remove('show');
            }
        });
    });

    submenubotoes.forEach(button => {
        button.addEventListener('click', (event) => {
            event.stopPropagation();

            // Fechar o submenu
            portfolioSubmenu.classList.remove('show');

            // Fechar o menu principal (menu-container)
            const menu = document.querySelector('.menu-container');
            menu.classList.add('hide');
            setTimeout(() => {
                menu.classList.remove('show', 'hide');
            }, 250); // Tempo igual à duração da animação de fechamento

            // Restante da lógica para alternar as seções
            submenubotoes.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            document.querySelectorAll('.content-section').forEach(section => section.classList.remove('active'));
            const targetSection = document.getElementById(button.dataset.section);

            if (targetSection) {
                targetSection.classList.add('active');
            }

            document.getElementById('portfolio').classList.add('active');

            if (window.innerWidth < 768) {
                portfolioSubmenu.classList.remove('show');
            }

            // Definir o botão ativo
            setbotaoAgora(); // Adicione esta linha
        });
    });

});

document.addEventListener('DOMContentLoaded', () => {
    
    

    // Manter aberto após clique
    submenubotoes.forEach(button => {
        button.addEventListener('click', (event) => {
            event.stopPropagation();
            keepOpen = true;

            submenubotoes.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            document.querySelectorAll('.content-section').forEach(section => {
                section.classList.remove('active');
            });

            const targetSection = document.getElementById(button.dataset.section);
            if (targetSection) {
                targetSection.classList.add('active');
            }

            document.getElementById('portfolio').classList.add('active');

            // Definir o botão ativo
            setbotaoAgora(); // Adicione esta linha
        });
    });

    // Alternar exibição do submenu ao clicar no botão Portfólio
    portfolioBtn.addEventListener('click', () => {
        if (!portfolioSubmenu.classList.contains('show')) {
            portfolioSubmenu.classList.add('show');
            animateSubmenuItems();
        }
    });

    // Alternar seções de projetos ao clicar nos botões do submenu
    
});