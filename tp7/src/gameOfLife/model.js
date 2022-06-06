import {
  GAME_SIZE,
  CELL_STATES,
  DEFAULT_ALIVE_PAIRS,
  RENDER_INTERVAL, CELL_SIZE, CELL_SPACING
} from "./constants.js";
import {drawGame} from "./view";

export class Model {
  constructor() {
    this.width = GAME_SIZE;
    this.height = GAME_SIZE;
    this.raf = null;
  }

  init() {
    this.state = Array.from(new Array(this.height), () =>
      Array.from(new Array(this.width), () => CELL_STATES.NONE)
    );
    DEFAULT_ALIVE_PAIRS.forEach(([x, y]) => {
      this.state[y][x] = CELL_STATES.ALIVE;
    });
    this.neighbours =  this.state;
    this.updated();
  }

  run(date = new Date().getTime()) {
    this.raf = requestAnimationFrame(() => {
      const currentTime = new Date().getTime();
      if (currentTime - date > RENDER_INTERVAL) {

        for (let i = 0; i < this.width; i++) {
          for (let j = 0; j < this.height; j++) {
            const nbAlive = this.aliveNeighbours(i, j);
            if (nbAlive > 3 || nbAlive < 2) {
              this.neighbours[i][j] = CELL_STATES.DEAD; // Plus que 3 ou moins que 2 en vie: la cellule meurt
            }
            if (nbAlive === 2) {
              this.neighbours[i][j] = this.state[i][j]; // 2 en vie : conserver l'état
            }
            if (nbAlive === 3) {
              this.neighbours[i][j] = CELL_STATES.ALIVE; // 3 en vie : générer une cellule vivante
            }
          }
        }

        this.updated();
        this.run(currentTime);
      } else {
        this.run(date);
      }
    });
  }

  stop() {
    cancelAnimationFrame(this.raf);
    this.raf = null;
  }

  reset() {
    this.init();
    this.stop();
  }

  isCellAlive(x, y) {
    return x >= 0 &&
      y >= 0 &&
      y < this.height &&
      x < this.height &&
      this.state[y][x] === CELL_STATES.ALIVE
      ? 1
      : 0;
  }

  aliveNeighbours(x, y) {
    let number = 0;
    for (let i = x-1; i <= x+1; i++) {
      for (let j = y-1; j <= y+1; j++) {
        number += (i !== x || j !== y) && this.isCellAlive(j, i) ? 1 : 0;
      }
    }
    return number;
  }

  toggleCellState(x, y) {
    let i = Math.floor(x/(CELL_SIZE + CELL_SPACING));
    let j = Math.floor(y/(CELL_SIZE + CELL_SPACING));
    this.state[i][j] = this.state[i][j] === CELL_STATES.ALIVE ? CELL_STATES.DEAD : CELL_STATES.ALIVE;
    drawGame(this);
  }

  updated() {
    this.state = this.neighbours;
    this.neighbours = Array.from(new Array(this.height), () =>
        Array.from(new Array(this.width), () => CELL_STATES.NONE)
    );
    drawGame(this);
  }
}
