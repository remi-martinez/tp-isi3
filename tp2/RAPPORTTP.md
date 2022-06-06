**Nom/Prénom Etudiant :** MARTINEZ AUBERT



# Rapport TP: Design Pattern Decorateur


### Itération 2
*présentez différentes solutions en donnant le diagramme de classes, discutez*
   * Proposez différentes solutions possibles dans le rapport pour réaliser cela et discutez leurs avantages/inconvénients lors de l'ajout de nouveaux suppléments et boissons (facilité d’ajout, respect du principe OCP ?).
#### Solution 1:
On crée une classe abstraite `Supplement` ainsi que différentes classes pour tout les suppléments possibles avec leur propre nom et prix. Pour ajouter plusieurs suppléments on crée une classe par combinaison de suppléments (ex: CaramelChantilly.java, MilkSugar.java, ...)
La classe `Coffee` va quant à elle avoir un attribut `Supplement`.
 
⚠️ Problème: Cela serait trop lourd à implémenter et ne respecterai pas OCP

![image](https://user-images.githubusercontent.com/28193334/159690213-a3360831-4f92-47cc-912c-89facfb35009.png)

#### Solution 2:
On crée juste une classe abstraite `Supplement` ainsi que 4 classes pour les suppléments actuels qui vont hériter de `Supplement`

![image](https://user-images.githubusercontent.com/28193334/159688891-04a327ca-a40c-49d2-82f9-2a6eaf64b690.png)

Au niveau de la classe `Coffee` on va cette fois-ci, ajouter une collection de Supplement qui va nous éviter d'avoir tout un ensemble de combinaisons de suppléments. On va ajouter chaque supplement à la collection au moment de la selection sur le distributeur.

![image](https://user-images.githubusercontent.com/28193334/160358501-b2dbc2e8-4e25-4ea9-b4fa-21b64ee2e60b.png)


### Itération 3
*présentez votre solution en donnant le diagramme de classes et en expliquant comment vous avez appliqué le design pattern Decorateur*

Pour implémenter le design pattern décorator, nous avons créer une classe abstraite article qui va être le lien entre la classe supplementDécorater et les différents types de cafés. Dans cette classe abstraite on retrouvera le prix et le nom ainsi que les getters de ces attributs. Ensuite chaque décorateur concret va hériter de la classe abstraite supplementDecorater et définir dans leur constructeur l'ajout de leur prix au cout tôtal du café et ses différents suppléments.

![image](https://user-images.githubusercontent.com/64494563/160376978-8689b050-1bbe-4dca-b894-82bc0881cd62.png)

*discutez la facilité d’ajouter de nouveaux éléments (boissons et suppléments) en comparaison avec les solutions précédentes*

Pour l'ajout de nouveaux éléments au distributeur de café nous avons juste à créer un nouveau décorateur pour un supplément par exemple. L'ajout de nouveaux composants (café/supplément) est completement indépendant du reste du distributeur, ce qui permet d'en ajouter de nouveaux très facilement et rapidement.


*conclusion(s) ?*

L'intéret de ce pattern est que nous pouvons étendre le comportement de fonctionnalités sans avoir besoin de créer de sous classe et également ajouter plusieurs suppléments en "emballant" le café dans plusieurs décorateurs. Ce pattern réspecte également très bien le principe de résponsabilité unique en séparent chaque comportements en plusieurs décorateurs.

### Questions
_Expliquez comment le package `java.io.Reader` implémente le pattern Décorateur (donner un diagramme UML, expliquez, illustrez l'utilisation de ce pattern sur un exemple d'utilisation du package)._

![image](https://user-images.githubusercontent.com/64494563/160380362-c1ec05df-47cb-496d-9019-0e52d967fde4.png)

* `Reader` représente le composant (tout en haut)
* `InputStreamReader` représente le composant concret
* `LineNumberReader` représente un décorateur concret
* `FileReader` représente un décorateur concret
* `BufferedReader` représente aussi un décorateur concret, car il ajoute une méthode supplémentaire par rapport à la classe abstraite Reader

Exemple d'utilisation :
Lecture d'un fichier avec `FileReader` :
```java
FileReader fileReader = new FileReader("fichier.txt");
BufferedReader bufferedReader = new BufferedReader(fileReader); // utilisation du décorateur
```

