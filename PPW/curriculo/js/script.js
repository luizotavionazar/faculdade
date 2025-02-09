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
            activeButton.classList.add('active'); }

        // Fechar submenu ao trocar de seção (exceto se for portfolio)
        if (sectionId !== 'portfolio') {
            portfolioSubmenu.classList.remove('show'); }
    }

    buttons.forEach(button => {
        button.addEventListener('click', () => {
            const sectionId = button.dataset.section;
            showSection(sectionId);

            // Fechar submenu se não for o botão do Portfólio
            if (sectionId !== 'portfolio') {
                portfolioSubmenu.classList.remove('show'); }

            // Em dispositivos móveis, ocultar menu após clicar
            if (window.innerWidth < 768 && sectionId !== 'portfolio') {
                document.querySelector('.menu-container').classList.remove('show'); }
            });
    });
});

// Alterna o tema
document.addEventListener('DOMContentLoaded', function() {
    const toggleButton = document.getElementById('themeToggle');
    const themeIcon = document.querySelector('.icone-tema');
    const currentTheme = localStorage.getItem('theme') || 'light';

    document.documentElement.setAttribute('data-theme', currentTheme);
    updateIcon(currentTheme); // Define o ícone inicial

    toggleButton.addEventListener('click', function(event) {
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
        }, 200);
        
      }
});   

// Alterna a exibição do menu em dispositivos móveis
document.addEventListener('DOMContentLoaded', function() {
    const menuToggleBtn = document.getElementById('menuToggleBtn');
    const menuContainer = document.querySelector('.menu-container');
    const iconeMenu = document.querySelector('.icone-menu'); // Seleciona o ícone
    const menuButtons = document.querySelectorAll('.menu-button');

    function animateMenuItems() {
        menuButtons.forEach((button, index) => {
            button.style.opacity = '0';
        button.style.transform = 'translateX(-20px)';
        setTimeout(() => {
            button.style.opacity = '1';
            button.style.transform = 'translateX(0)';
            }, index * 1000);
        });
    }

    menuToggleBtn.addEventListener('click', function() {
        iconeMenu.classList.remove('expandir'); // Garante que a animação sempre funcione
        iconeMenu.classList.add('encolher'); // Inicia a animação de encolher
        setTimeout(() => {
            iconeMenu.classList.remove('encolher'); // Remove a classe de encolher

            if (menuContainer.classList.contains('show')) {
                iconeMenu.classList.remove('fa-caret-down');
                iconeMenu.classList.add('fa-caret-up');
            } else {
                iconeMenu.classList.remove('fa-caret-up');
                iconeMenu.classList.add('fa-caret-down');
                if (window.innerWidth < 768) {
                    animateMenuItems();
                }
            }

            iconeMenu.classList.add('expandir'); // Inicia a animação de expandir
        }, 100); // Tempo da animação (ajuste se necessário)

        menuContainer.classList.toggle('show'); // Isso fica por último para garantir a troca do ícone antes da animação de expandir

        if (menuContainer.classList.contains('show')) {
            const menuButtons = document.querySelectorAll('.menu-button');
            menuButtons.forEach((button, index) => {
                button.style.opacity = '0'; // Define a opacidade inicial como 0
                button.style.transform = 'translateX(-20px)'; // Define a posição inicial
                setTimeout(() => {
                    button.classList.add('animar'); // Adiciona a classe para iniciar a animação
                }, index * 100); // Atraso para cada botão
            });
        }
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
            }, index * 100);
        });
    }

    // Controle de hover
    portfolioBtn.addEventListener('mouseenter', () => {
        if (!portfolioSubmenu.classList.contains('show')) {
            portfolioSubmenu.classList.add('show');
            animateSubmenuItems(); }
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
            targetSection.classList.add('active'); }

        document.getElementById('portfolio').classList.add('active');
        });
    });

    // Fechar quando clicar em outros menus
    document.querySelectorAll('.menu-button').forEach(button => {
        button.addEventListener('click', () => {
        if (button.dataset.section !== 'portfolio') {
            keepOpen = false;
            portfolioSubmenu.classList.remove('show'); }
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
            
            // Remover classe active de todos os botões
            submenuButtons.forEach(btn => btn.classList.remove('active'));
            
            // Adicionar classe active no botão clicado
            button.classList.add('active');

            // Adicionar classe ao botão Portfólio para mudar a cor
            portfolioBtn.classList.add('submenu-active');
            
            document.querySelectorAll('.content-section').forEach(section => section.classList.remove('active'));
            const targetSection = document.getElementById(button.dataset.section);
            
            if (targetSection) {
              targetSection.classList.add('active'); }    
            
            document.getElementById('portfolio').classList.add('active'); 
            
            if (window.innerWidth < 768) {
              portfolioSubmenu.classList.remove('show'); }
        });
    
        // Remover a cor do botão Portfólio ao clicar em outro menu
    document.querySelectorAll('.menu-button').forEach(button => {
        button.addEventListener('click', () => {
            if (button.dataset.section !== 'portfolio') {
                portfolioBtn.classList.remove('submenu-active'); }
            });
        });
    });
    document.addEventListener('DOMContentLoaded', () => {
        const menuButtons = document.querySelectorAll('.menu-button');
        const submenuButtons = document.querySelectorAll('.submenu-button');
        const portfolioBtn = document.getElementById('portfolioBtn');
    
        function resetButtons() {
            menuButtons.forEach(btn => btn.classList.remove('active'));
            submenuButtons.forEach(btn => btn.classList.remove('active'));
        }
    
        // Evento para os botões principais do menu
        menuButtons.forEach(button => {
            button.addEventListener('click', () => {
                resetButtons(); // Reseta tudo
                button.classList.add('active'); // Adiciona classe ativa apenas ao botão clicado
            });
        });
    
        // Evento para os botões do submenu
        submenuButtons.forEach(button => {
            button.addEventListener('click', () => {
                resetButtons(); // Reseta todos os botões, incluindo os principais
                button.classList.add('active'); // Adiciona classe ativa apenas ao submenu clicado
                portfolioBtn.classList.add('active'); // Mantém o botão Portfólio ativo
            });
        });
    
        // Reseta os outros botões quando o mouse passa no Portfólio
        portfolioBtn.addEventListener('mouseenter', () => {
            menuButtons.forEach(btn => {
                if (btn !== portfolioBtn) {
                    btn.classList.remove('active'); // Remove a classe active dos outros botões
                }
            });
        });
    });
});