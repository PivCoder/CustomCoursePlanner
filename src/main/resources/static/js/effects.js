const sidebar = document.getElementById('sidebar');
const menuButton = document.getElementById('menu-button');
const gridmerge = document.getElementsByClassName('grid-container')

menuButton.addEventListener('click', () => {
    const icons = document.querySelectorAll('.sidebar .icon');

    if (sidebar.style.width === '60px' || !sidebar.style.width) {
        sidebar.style.width = '200px';

        // Показать текст, убрав класс 'hidden'
        icons.forEach((icon) => {
            const text = icon.querySelector('span');
            if (text) {
                text.classList.remove('hidden');
            }
        });
    } else {
        sidebar.style.width = '60px';

        // Скрыть текст, добавив класс 'hidden'
        icons.forEach((icon) => {
            const text = icon.querySelector('span');
            if (text) {
                text.classList.add('hidden');
            }
        });
    }
});
