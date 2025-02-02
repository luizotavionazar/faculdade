document.addEventListener('DOMContentLoaded', function() {
    const toggleButton = document.getElementById('themeToggle');
    const currentTheme = localStorage.getItem('theme') || 'light';

    document.documentElement.setAttribute('data-theme', currentTheme);
    toggleButton.textContent = currentTheme === 'dark' ? 'Tema Claro' : 'Tema Escuro';

    toggleButton.addEventListener('click', function() {
        let theme = document.documentElement.getAttribute('data-theme') === 'light' ? 'dark' : 'light';
        document.documentElement.setAttribute('data-theme', theme);
        localStorage.setItem('theme', theme);
        toggleButton.textContent = theme === 'dark' ? 'Tema Claro' : 'Tema Escuro';
    });
});