# ISI3 TP 1: Design Pattern Stratégie
Laëtitia Matignon


> Le rapport est à saisir dans le ficher [RAPPORTTP1.md](RAPPORTTP1.md) en utilisant le [formalisme MarkDown](https://guides.github.com/features/mastering-markdown/).


### Rappel: le pattern Stratégie

*Le pattern Stratégie a pour objectif d'adapter le comportement et les algorithmes d'un objet en fonction d'un besoin sans changer les interactions de cet objet avec les clients*.

![strategy-uml](img/strategy-uml.svg)

- la **stratégie**, c'est l'interface qui va définir la(les) méthode(s) des stratégies (options) que l'on va implémenter
- les **stratégies**, *(les opérations de la calculette par exemple)* vont implémenter l'interface **stratégie**
- le **contexte**, c'est la classe qui va utiliser les stratégies pour faire toujours la même action mais avec un résultat différent à chaque fois (par exemple notre classe `Calculette` qui va utiliser des opérations)

> autre exemple: modes de transport

![strategy-use-case](img/strategy-use-case.svg)




## Exercice 1: Happy Hour 

**Enoncé/contexte**: Modéliser le concept d'happy hour dans un pub. Le serveur sert des bières sur lesquelles il peut appliquer des réductions.
- le serveur est le contexte
- les réductions sont les stratégies

**À faire**: dans le projet `/beers`
- ajoutez le code nécessaire pour que les tests fonctionnent (exécutez la classe [classe HappyHourTest](src/strategybeers/HappyHourTest.java))
- ajoutez une réduction de 50%
- complétez la classe de test [classe HappyHourTest](src/strategybeers/HappyHourTest.java) et vérifier le bon fonctionnement de cette nouvelle réduction.

![exo-01](img/exo-01.png)

## Exercice 2: Calculette


**Enoncé/contexte**: Modéliser le concept d'une Calculette. 

### Faites une calculette

- complétez la classe [classe Calculette](src/calculette/Calculette.java) et la classe [classe Main](src/calculette/Main.java) pour pouvoir réaliser l'opération d'addition entre deux réels. Faites ici **au plus simple**, sans utilisation de *design pattern*.
- ajoutez la soustraction.
- ajoutez la multiplication
- ajoutez la division

### Discutons

- présentez votre solution dans le [RAPPORTTP1.md](RAPPORTTP1.md)
- conclusion(s) (en particulier concernant les conséquences de l'ajout de nouvelles opérations) ?

## Exercice 3: Calculette et Stratégie

> Comment ajouter des opérations à la classe `Calculette` sans être obligé de la modifier à chaque fois?

- re-faites la calculette en utilisant le pattern **Strategie**.  Vous compléterez les classes [classe CalculetteStrategy](src/strategycalculette/CalculetteStrategy) et [classe Main](src/strategycalculette/Main)

### Discutons

- présentez votre solution dans le [RAPPORTTP1.md](RAPPORTTP1.md)
- conclusion(s) concernant votre nouvelle modélisation ?

## Questions
- Quelles sont les différences entre le patron de conception Etat et le patron Stratégie ?

- Quel(s) principe(s) SOLID est (sont) respecté par le design pattern Strategy ?


