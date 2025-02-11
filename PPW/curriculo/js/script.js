// Alterna as seções do menu
document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.menu-button');
    const sections = document.querySelectorAll('.content-section');

    function showSection(sectionId) {
        sections.forEach(section => section.classList.remove('active'));
        buttons.forEach(button => button.classList.remove('active'));

        const activeSection = document.getElementById(sectionId);
        const activeButton = document.querySelector(`[data-section="${sectionId}"]`);

        if (activeSection && activeButton) {
            activeSection.classList.add('active');
            activeButton.classList.add('active');
        }

        // Fechar submenu ao trocar de seção (exceto se for portfolio)
        if (sectionId !== 'portfolio') {
            portfolioSubmenu.classList.remove('show');
        }
    }

    buttons.forEach(button => {
        button.addEventListener('click', () => {
            const sectionId = button.dataset.section;
            showSection(sectionId);

            // Fechar submenu se não for o botão do Portfólio
            if (sectionId !== 'portfolio') {
                portfolioSubmenu.classList.remove('show');
            }

            // Em dispositivos móveis, ocultar menu após clicar
            if (window.innerWidth < 768 && sectionId !== 'portfolio') {
                const menuContainer = document.querySelector('.menu-container');
                menuContainer.classList.add('hide');

                setTimeout(() => {
                    menuContainer.classList.remove('show', 'hide');
                }, 300); // Tempo igual à duração da transição
            }

            // Definir o botão ativo
            setActiveButton(); // Adicione esta linha
        });
    });
});

// Alterna o tema
document.addEventListener('DOMContentLoaded', function () {
    const toggleButton = document.getElementById('themeToggle');
    const themeIcon = document.querySelector('.icone-tema');
    const currentTheme = localStorage.getItem('theme') || 'light';

    document.documentElement.setAttribute('data-theme', currentTheme);
    updateIcon(currentTheme); // Define o ícone inicial

    toggleButton.addEventListener('click', function (event) {
        event.preventDefault();
        let theme = document.documentElement.getAttribute('data-theme') === 'light' ? 'dark' : 'light';
        document.documentElement.setAttribute('data-theme', theme);
        localStorage.setItem('theme', theme);
        updateIcon(theme); // Atualiza o ícone
    });

    function updateIcon(theme) {
        themeIcon.classList.remove('expandir'); // Remove a classe de expandir para garantir que a animação funcione sempre
        themeIcon.classList.add('encolher'); // Adiciona a classe de encolher

        setTimeout(() => {
            themeIcon.classList.remove('encolher'); // Remove a classe de encolher após a animação

            if (theme === 'dark') {
                themeIcon.classList.remove('fa-moon');
                themeIcon.classList.add('fa-sun');
            } else {
                themeIcon.classList.remove('fa-sun');
                themeIcon.classList.add('fa-moon');
            }
        }, 100);
    }
});

// Alterna a exibição do menu em dispositivos móveis
document.addEventListener('DOMContentLoaded', function () {
    const menuToggleBtn = document.getElementById('menuToggleBtn');
    const menuContainer = document.querySelector('.menu-container');
    const iconeMenu = document.querySelector('.icone-menu'); // Seleciona o ícone
    const menuButtons = document.querySelectorAll('.menu-button');
    const portfolioBtn = document.getElementById('portfolioBtn');
    const portfolioSubmenu = document.getElementById('portfolioSubmenu');
    const submenuButtons = document.querySelectorAll('.submenu-button');

    // Função para resetar os botões
    function resetButtons() {
        menuButtons.forEach(btn => btn.classList.remove('active'));
        submenuButtons.forEach(btn => btn.classList.remove('active'));
        portfolioBtn.classList.remove('submenu-active');
    }

    // Função para definir o botão ativo com base na seção ativa
    function setActiveButton() {
        const activeSection = document.querySelector('.content-section.active');
        if (activeSection) {
            const activeButton = document.querySelector(`[data-section="${activeSection.id}"]`);
            if (activeButton) {
                activeButton.classList.add('active');
                if (activeSection.id.startsWith('portfolio')) {
                    portfolioBtn.classList.add('submenu-active');
                }
            }
        }
    }

    function animateMenuItems() {
        menuButtons.forEach((button, index) => {
            button.style.opacity = '0';
            button.style.transform = 'translateX(-20px)';
            setTimeout(() => {
                button.style.opacity = '1';
                button.style.transform = 'translateX(0)';
            }, index * 150);
        });
    }

    // Impede que o menu feche ao clicar dentro dele
    menuContainer.addEventListener('click', function (event) {
        event.stopPropagation();
    });

    // Evento de clique no botão de alternância do menu
    menuToggleBtn.addEventListener('click', function (event) {
        event.stopPropagation(); // Impede a propagação do evento

        // Alternar entre os ícones de "abrir" e "fechar"		
        if (iconeMenu.classList.contains('fa-caret-down')) {		
	            iconeMenu.classList.remove('fa-caret-down');		
	            iconeMenu.classList.add('fa-caret-up'); // Ícone para menu aberto		
	        } else {		
	            iconeMenu.classList.remove('fa-caret-up');		
	            iconeMenu.classList.add('fa-caret-down'); // Ícone para menu fechado		
	        }

        iconeMenu.classList.remove('expandir');
        iconeMenu.classList.add('encolher');

        setTimeout(() => {
            iconeMenu.classList.remove('encolher');

            // Verifica o estado atual do menu
            const isOpening = !menuContainer.classList.contains('show');

            if (isOpening) {
                // Animação de abertura
                menuContainer.classList.remove('hide');
                menuContainer.classList.add('show');
                animateMenuItems();

                // Resetar os botões e definir o botão ativo
                resetButtons();
                setActiveButton();
            } else {
                // Animação de fechamento
                menuContainer.classList.add('hide');
                setTimeout(() => {
                    menuContainer.classList.remove('show', 'hide');
                }, 200);
            }

            iconeMenu.classList.add('expandir');
        }, 50);
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const portfolioBtn = document.getElementById('portfolioBtn');
    const portfolioSubmenu = document.getElementById('portfolioSubmenu');
    const submenuButtons = document.querySelectorAll('.submenu-button');
    let keepOpen = false;

    // Função para animar os itens do submenu
    function animateSubmenuItems() {
        submenuButtons.forEach((button, index) => {
            button.style.opacity = '0';
            button.style.transform = 'translateX(-20px)';
            setTimeout(() => {
                button.style.opacity = '1';
                button.style.transform = 'translateX(0)';
            }, index * 200);
        });
    }

    // Controle de hover
    portfolioBtn.addEventListener('mouseenter', () => {
        if (!portfolioSubmenu.classList.contains('show')) {
            portfolioSubmenu.classList.add('show');
            animateSubmenuItems();
        }
    });

    // Manter aberto após clique
    submenuButtons.forEach(button => {
        button.addEventListener('click', (event) => {
            event.stopPropagation();
            keepOpen = true;

            submenuButtons.forEach(btn => btn.classList.remove('active'));
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
            setActiveButton(); // Adicione esta linha
        });
    });

    // Fechar quando clicar em outros menus
    document.querySelectorAll('.menu-button').forEach(button => {
        button.addEventListener('click', () => {
            if (button.dataset.section !== 'portfolio') {
                keepOpen = false;
                portfolioSubmenu.classList.remove('show');
            }
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
    submenuButtons.forEach(button => {
        button.addEventListener('click', (event) => {
            event.stopPropagation();

            // Fechar o submenu
            portfolioSubmenu.classList.remove('show');

            // Fechar o menu principal (menu-container)
            const menuContainer = document.querySelector('.menu-container');
            menuContainer.classList.add('hide');
            setTimeout(() => {
                menuContainer.classList.remove('show', 'hide');
            }, 250); // Tempo igual à duração da animação de fechamento

            // Restante da lógica para alternar as seções
            submenuButtons.forEach(btn => btn.classList.remove('active'));
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
            setActiveButton(); // Adicione esta linha
        });
    });

    document.querySelectorAll('.menu-button').forEach(button => {
        button.addEventListener('click', () => {
            if (button.dataset.section !== 'portfolio') {
                portfolioBtn.classList.remove('submenu-active');
            }
        });
    });
});