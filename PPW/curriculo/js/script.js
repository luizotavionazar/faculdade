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
            themeIcon.classList.toggle('fa-moon', theme !== 'dark'); // Lua para tema claro
            themeIcon.classList.toggle('fa-sun', theme === 'dark'); // Sol para tema escuro
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
    const secaoTitulo = document.getElementById('sessao-titulo');
    const titulosSecao = {
        pessoal: "QUEM SOU EU?",
        habilidades: "HARD/SOFT SKILLS",
        formacao: "FORMAÇÃO ACADEMICA",
        experiencias: "HISTÓRICO PROFISSIONAL",
        portfolio: "COLEÇÃO DE TRABALHOS",
        contato: "ENTRE EM CONTATO",
        item1: "Projeto 1",
        item2: "Projeto 2",
        item3: "Projeto 3",
        item4: "Projeto 4",
        item5: "Projeto 5"
    };

    function ativarMenu(secaoId) { // Função para exibir o conteudo da seção clicada e ativar o botão clicado
        secoes.forEach(section => section.classList.remove('active')); // Para exibir apenas o conteudo da seção clicada
        botoes.forEach(button => button.classList.remove('active')); // Para apenas o botão clicado ficar ativo

        const secaoAgora = document.getElementById(secaoId);
        const botaoAgora = document.querySelector(`[data-section="${secaoId}"]`);
        const secaoAtual = document.querySelector('.content-section.active');

        if (secaoAtual && secaoAgora && secaoAtual !== secaoAgora) {
            secaoAtual.classList.add('fade-out'); // Realiza a animação de fade out
            secaoAtual.addEventListener('animationend', () => { // Espera a animação de fade out terminar antes de trocar de seção
                secaoAtual.classList.remove('active', 'fade-out');
                secaoAgora.classList.add('active');
                secaoTitulo.textContent = titulosSecao[secaoId] || "Seção Desconhecida";
            }, { once: true });
        } else if (secaoAgora && !secaoAtual) { // Caso não haja uma seção ativa, apenas ativa a nova seção
            secaoAgora.classList.add('active');
            secaoTitulo.textContent = // Atualiza o texto da seção no nav
            secaoTitulo.textContent = titulosSecao[secaoId] || "Seção Desconhecida";
        }

        botoes.forEach(button => button.classList.remove('active'));
        if (botaoAgora) {
            botaoAgora.classList.add('active');
        }

        if (secaoAgora && botaoAgora) { // Ativa a seção e o botão clicado
            secaoAgora.classList.add('active');
            botaoAgora.classList.add('active');
        }

        if (secaoId !== 'portfolio') { // Fechar submenu ao trocar de seção
            portfolioSubmenu.classList.remove('show');
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

    const portfolioBtn = document.getElementById('portfolioBtn');
    const submenubotoes = document.querySelectorAll('.submenu-button');
    let keepOpen = false;

    function animaSubMenu() { // Função para animar os itens do submenu
        submenubotoes.forEach((button, index) => {
            button.style.opacity = '0';                     //transformar em CSS
            button.style.transform = 'translateX(-20px)';
            setTimeout(() => {
                button.style.opacity = '1';
                button.style.transform = 'translateX(0)';
            }, index * 160);
        });
    }

    portfolioBtn.addEventListener('click', () => { // Animação do submenu ao passar o mouse
        if (!portfolioSubmenu.classList.contains('show')) {
            portfolioSubmenu.classList.add('show');
            animaSubMenu();
        }
    });

    document.querySelectorAll('.menu-button').forEach(button => { //Fecha o submenu ao clicar em outro botão do menu
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

            if (window.innerWidth < 768) { // Fecha o submenu ao selecionar a opção no telefone
                portfolioSubmenu.classList.remove('show'); // Fechar o submenu
                const menu = document.querySelector('.menu-container'); // Fechar o menu principal (menu-container)
                menu.classList.add('hide');
                setTimeout(() => {
                    menu.classList.remove('show', 'hide');
                }, 450); // Tempo igual à duração da animação de fechamento
            }
            
            submenubotoes.forEach(btn => btn.classList.remove('active')); // Remover a classe active de todos os botões

            document.querySelectorAll('.content-section').forEach(section => section.classList.remove('active'));
            const targetSection = document.getElementById(button.dataset.section);

            if (targetSection) {
                targetSection.classList.add('active');
            }

            document.getElementById('portfolio').classList.add('active'); //Exibe o conteudo selecionado do portfólioz
            document.getElementById('portfolioBtn').classList.add('active');
        });
    });
    //--------------------MENU----------------------
    
});