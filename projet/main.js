const reservationButt = document.getElementById('reservation');
const signinButt = document.getElementById('signin');
const container = document.getElementById('container');


reservationButt.addEventListener('click', () => 
container.classList.add('right-panel-active'));

signinButt.addEventListener('click', () => 
container.classList.remove('right-panel-active'));

