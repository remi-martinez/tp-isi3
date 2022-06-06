import {changeCanvasDimension} from "./view";

let gameModel;

export const controller = model => {
  gameModel = model;
};

const startBtn = document.getElementById('start');
const stopBtn = document.getElementById('stop');
const resetBtn = document.getElementById('reset');
const gameSizeInput = document.getElementById("gameSize");

export function canvasClicked(canvas, e) {
  let x = e.clientX - canvas.getBoundingClientRect().left;
  let y = e.clientY - canvas.getBoundingClientRect().top;
  gameModel.toggleCellState(x,y);
}

function setFormDisabled(state) {
  gameSizeInput.disabled = state;
}

gameSizeInput.addEventListener('change', (e) => {
  changeCanvasDimension("height", e.target.value);
  changeCanvasDimension("width", e.target.value);
  gameModel.width = parseInt(gameSizeInput.value);
  gameModel.height = parseInt(gameSizeInput.value);
  gameModel.reset();
})

startBtn.addEventListener('click', () => {
  setFormDisabled(true);
  gameModel.run();
});

stopBtn.addEventListener('click', () => {
  setFormDisabled(false);
  gameModel.stop();
});

resetBtn.addEventListener('click', () => {
  setFormDisabled(false);
  gameModel.stop();
  gameModel.reset();
});
