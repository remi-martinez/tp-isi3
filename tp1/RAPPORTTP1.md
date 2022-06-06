**Nom/Prénom Etudiant  :** MARTINEZ Rémi, AUBERT Baptiste



# Rapport TP1 : Design Pattern Stratégie

## Exercice 2
*Expliquer le code ajouté, présentez votre solution (diagramme UML et texte), conclusion(s) ?*  
Dans `Calculette.java` : Ajout des variables `c1`, `c2` et operation représentant les deux chiffres en `float` et l'opération (`String`) qui être effectuée entre ces deux chiffres.  
Ajout des `getter/setter` également.  

La méthode `calcul()` effectue un switch sur l'opération :  
  * s'il s'agit d'une addition on fait `c1 + c2`
  * s'il s'agit d'une soustraction on fait `c1 - c2`
  * s'il s'agit d'une multiplication on fait `c1 * c2`
  * s'il s'agit d'une division, on fait dans un `try` sur `c1 / c2` avec un `catch` qui récupère une erreur `ArithmeticException` au cas où le dénominateur est nul.

On a également fait un constructeur en initialisant en paramètre les deux chiffres et l'opération.  
Et on `print` just le résultat de cette calculette obtenu avec `calc.calcul();`

**Diagramme UML**  
![image](https://user-images.githubusercontent.com/64494563/154679692-48027681-f3c8-4fb1-afa6-329b45fc9a9f.png)


**Conclusion :** Cette méthode est la plus simple à implémenter, mais ne respecte pas le principe de Open-closed : si on veut rajouter une opération, on va devoir aller modifier
le code source de la classe Calculette.




## Exercice 3
*Expliquer le code ajouté: présentez votre solution (diagramme UML et texte), conclusion(s) ?*
1. Pour la calculette implementée avec le design pattern _Stratégie_, nous avons la classe `CalculetteStat.java` qui va être la base car c'est elle qui va être appelé pour réaliser les calculs en fonction de la stratégie choisie (addition, soustraction, ...).
2. Ensuite, l'interface `ICalculStrategy` qui va être commune à tout les différents calculs
3. Par la suite, on va définir les différents stratégies dans les classes `Addition.java`, `Soustraction.java`, `Multiplication.java` et `Division.java` en fonction du calcul à effectuer en implémentant l'interface.
4. Enfin, on rajoute l'attribut stratégie et son setter à la classe de base `CalculetteStrat.java` afin de garder une référence vers un objet stratégie.

**Conclusion :** Cette méthode va nous permettre de rajouter des opérations plus facilement et rapidement et surtout en respectant le principe Open-closed car nous n'avons plus besoin de modifier le code de la classe de base mais seulement de rajouter une nouvelle implémentation de l'interface pour rajouter une méthode.

## Questions
*Répondre aux questions*
### Quelles sont les différences entre le patron de conception Etat et le patron Stratégie ?
Dans le design pattern Stratégie, il n'y a aucun lien entre les stratégies elle-mêmes contrairement au patron Etat qui va souvent lier plusieurs états (pour réaliser des workflows par exemple).

### Quel(s) principe(s) SOLID est (sont) respecté par le design pattern Strategy ?
  * Single Responsibility Principle -> Chaque sous-classe sert à une seule chose
  * Open / Closed Principle -> Il est possible de rajouter des extensions sans modifier l'existant
  * Liskov Substitution Principle -> Les sous-classes implémentent l'interface
  * Interface Segregation Principle -> Interface des stratégies





