import { GAME_SIZE, CELL_SIZE } from "./constants.js";
import {canvasClicked} from "./controller";

const canvas = document.createElement("canvas");
const context = canvas.getContext("2d");

const drawCell = (x, y, value) => {
  context.fillStyle = value;
  context.fillRect(x + CELL_SIZE * x, y + CELL_SIZE * y, CELL_SIZE, CELL_SIZE);
};

canvas.addEventListener('click', (e) => {
  canvasClicked(canvas, e);
})

export const initView = () => {
  document.getElementById("game").appendChild(canvas);
  canvas.setAttribute("height", GAME_SIZE * CELL_SIZE + GAME_SIZE - 1);
  canvas.setAttribute("width", GAME_SIZE * CELL_SIZE + GAME_SIZE - 1);

  document.getElementById("gameSize").value = GAME_SIZE;
};

export const changeCanvasDimension = (property, value) => {
  canvas.setAttribute(property, parseInt(value) * CELL_SIZE + parseInt(value) - 1);
}

export const drawGame = model => {
  model.state.forEach((row, rowIndex) => {
    row.forEach((value, columnIndex) => {
      drawCell(rowIndex, columnIndex, value);
    });
  });
};
