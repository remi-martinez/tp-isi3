if (!document.getElementById) document.write('<link rel="stylesheet" type="text/css" href="./style.css">');
import { initView, drawGame } from "./gameOfLife/view.js";
import { Model } from "./gameOfLife/model.js";
import { controller } from "./gameOfLife/controller.js";

initView();

const model = new Model();

model.init();
drawGame(model);
controller(model);
