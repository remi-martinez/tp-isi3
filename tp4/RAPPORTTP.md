**Nom/Prénom Etudiant 1 :**


# Rapport TP : Arbre et Design Pattern Visiteur

## Question 2
En cas d'ajout d'un nouveau type d'opérations il faudrait créer plusieurs méthodes pour l'affichage au sein d'entité qui peuvent être "fragiles" comme `Constante` ou les classes `OperateurBinaire` et `OperateurUnaire`. Ce qui n'est pas souhaité car ce code n'a pas à être directement au sein des entités et peut vite alourdir la classe.

## Question 3
![image](https://user-images.githubusercontent.com/28193334/161248644-e1a22786-8d8b-466c-9712-22b69c6a5af9.png)

## Question 5
*Expliquer le code ajouté pour un Visiteur d'affichage en notation postfixe*

On définit une méthode `visiterOperation` pour tout les types d'opérations en fonction de la logique de l'affichage postfixe
Pour les opérations avec deux cotés comme la multiplication et l'addition en visite l'élément de gauche puis celui de droite et on les ajoute à la pile, ensuite on ajoute l'opération.
Pour la négation on fait de même mais avec le seul élément qui est à gauche puis on ajoute le moins à la pile
Dès qu'une constante est visité elle est directement ajouter à la pile.
Ensuite on affiche la stack dans l'ordre qu'on l'a rempli en modifiant l'affichage des crochets.

## Question 6
*Définissez, implémentez et testez un Visiteur pour calculer la valeur d’une expression arithmétique.*
Dans le même principe que l'affichage on va créer une méthode de visite pour chaque opération et réaliser l'action correspondante. Par exemple lorsque l'on visite une multiplication on va visiter l'opérateur de gauche puis de droite et les multiplier afin d'ajouter le résultat à la pile. Si un des opérateurs est également une opération alors la méthode accept va permettre de visiter l'enfant et faire de même.

## Question 7
*Définissez, implémentez et testez un Visiteur pour afficher une expression en notation infixe. Il sera ici nécessaire d’utiliser des parenthèses si la priorité d’un nœud (en fait, celle de l’opérateur associé à ce nœud) est plus faible que la priorité du père de ce nœud (par exemple 7x(2+x)). Le code de l’arbre binaire pourra être modifié pour cette question.*
Pour la notation infixe, on rajoute un système de priorité afin de gérer l'ordre des opérations. Les opérations importantes tel que la multiplication ont une priorité plus importante que l'addition par exemple. Cette notion de priorité va nous permettre de mettre des parenthèses lorsque l'opérateur de droite d'une multiplication par exemple à une priorité plus faible que la multiplication (ex: 7 * (2+3), l'addition est plus faible que la multiplication donc on va ajouter des parenthèses).

## Question 8
*Discutez la facilité d’ajouter d'autres opérations sur l'expression arithmétique.*

Pour rajouter une nouvelle opération sur l'expression arithmétique il suffit maintenant de définir une nouvelle méthode appelant le décorateur approprié.

*Discutez la facilité d’ajouter d'autres types de Noeud à l'expression arithmétique.*

Dans le cas des noeuds, si l'on désire en ajouter un nouveau comme la division par exemple il va seulement falloir créer une nouvelle classe héritant de  `opérateurBinaire` par exemple et de rajouter dans l'interface `Visitor` une méthode `visiterDivision` qu'il faudra logiquement redéfinir dans les classes implémentants cette interface.

*Conclusion(s) sur le design pattern Visiteur ?*

Le design pattern Visiteur nous permet de séparer les algorithmes des objets sur lesquels ils agissent et ainsi il évite de devoir integrer les algos dans des classes existantes qui peuvent être parfois compliquées à modifier. Il nous permet donc d'appliquer le principe open/closed mais également le principe de responsabilité unique. Le design pattern Visiteur est très utile pour parcourir une structure complexe d'objets comme c'était le cas avec notre expression arithmétique.





