# ISI3 - MVC design pattern - "Game of Life"

> Le rapport est à fournir dans ce document sous chacune des questions.

> Ne copiez pas le code de votre voisin, ça se voit.

Nom/Prénom: AUBERT Baptiste & MARTINEZ Rémi

Lien du codesandbox: https://codesandbox.io/s/rzqstb  
(Il y a un bug avec codesandbox, si la grille ne charge pas utilisez le bouton ![image](https://user-images.githubusercontent.com/64494563/165317652-c23300ed-d16a-4943-988d-2b19ad3e0808.png)
 pour rafraîchir la fenêtre)

> Pour générer un codesandbox associé à votre code, [suivre cette doc](https://codesandbox.io/docs/importing#import-from-github).

Vous pouvez tester le code directement sur votre navigateur, à condition de lancer un serveur local. Par exemple :

```python3 -m http.server 8000```

Votre programme sera accessible depuis l'adresse `http://localhost:8000/index.html`.



## Game of Life

Le jeu de la vie est un automate cellulaire qui répond à des règles très simple.
Il a été inventé par [John Horton Conway](https://fr.wikipedia.org/wiki/John_Horton_Conway) (1937-2020).

## Avant-propos

1. Expliquer le design pattern MVC à l'aide d'un schéma à insérer directement ici.
Utiliser un outils comme Dia pour le représenter. Je veux **votre** schéma, pas un de ceux qu'on peut trouver sur le net.

![image](https://user-images.githubusercontent.com/64494563/162218586-0ada806b-34ec-4a05-9169-a958a0399a33.png)

Le pattern MVC permet de bien organiser le code, en répartissant les responsabilités en 3 parties :
* Le modèle : gère les données en les récupérant depuis une base de données par exemple pour les échanger avec le contrôleur.
* Le contrôleur : gère la logique du code qui prend les décisions, il fait office de passerelle d'échange entre le modèle et la vue.
* La vue : gère l'affichage et l'interface en se contentant seulement d'utiliser les variables reçues par le contrôleur


2. Expliquer ce pattern en complétant ce texte.

Le pattern MVP, vise à découper le `modèle`, de la `vue` et du `contrôleur` afin de rendre le code plus `organisé`.
Les responsabilités ne sont alors plus `regroupées`.
On peut ainsi changer l'aspect visuel de son application sans pour autant impacter le `modèle`.

3. Expliquer dans quels cas on doit privilégier le pattern MVC.

* Dans le cas d'une application de grande taille, comme il existe une séparation du code entre les trois niveaux, il devient extrêmement facile de diviser et d'organiser la logique d'application Web en applications à grande échelle
* On peut trouver plus rapidement des portions de code spécifiques et permettent l'ajout de nouvelles fonctionnalités en toute simplicité.
* Dans le cas des applications avec appels asynchrone, il est plus facile d'utiliser le pattern MVC
* Dans le cas où on veut créer notre propre "moteur de vue", car les données sont renvoyées sans formattage.

## À faire (obligatoire)

- Rendre le jeu fonctionel tout en respectant le design pattern MVC.
- Le bouton `start` doit lancer le jeu.
- Le bouton `stop` doit arrêter le jeu en l'état, le `start` relance le jeu.
- le bouton `reset` arrête le jeu et remet à la grille à l'état initial.

### Observer Observable

Afin de mettre à jour la vue à chaque nouvelle génération du jeu, la fonction `updated` doit notifier la view afin qu'elle se mette à jour.
Cela relève du design pattern Observer/Observable.

1. Expliquer votre implémentation:

L'usage d'un callback permet ici de `faire une boucle` afin de dire à la _View_ de se redessiner.
L'objet _Model_ n'a pas de lien avec `le contrôleur` pourtant grâce à la `méthode updated` il peut notifier la `vue`.

2. Insérer ici un UML montrant le pattern Observer/Observable lié aux objets de ce TP.

![image](https://user-images.githubusercontent.com/64494563/165334143-1608835c-ced7-4fa6-84be-fc0d3728e344.png)  
Généré par l'IDE :  
![image](https://user-images.githubusercontent.com/64494563/165334180-7392b7da-6026-487c-8ac3-e28a617dd5cc.png)  


## Optionnel

> Si vous voulez apprendre d'autres choses

- Faire en sorte de pouvoir changer les dimensions de la grille par un `<input/>` HTML. ✅
- Faire en sorte de pouvoir modifier l'état d'une cellule en cliquant dessus. ✅

## :warning: À rendre

- Une URL de codesandbox pointant sur votre projet github afin que je puisse voir et tester le code.
- Le rapport complet.
