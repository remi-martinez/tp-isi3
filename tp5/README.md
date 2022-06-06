# ISI3 TP Tests en Java
Laëtitia Matignon

> Le rapport est à saisir dans le ficher [RAPPORTTP.md](RAPPORTTP.md) en utilisant le [formalisme MarkDown](https://guides.github.com/features/mastering-markdown/).

![intro](img/Strip-Ou-sont-les-tests-unitaires-650-final.jpg)

## Objectifs
Dans ce TP, vous allez apprendre à définir des cas de tests et à les implémenter à l'aide de [JUnit5](https://junit.org/junit5/) et [Mockito](https://site.mockito.org).

## 1- Introduction
**Place des tests dans les méthodes de développement logiciel**

Lire : [Introduction aux tests](doc/cours3Test-Intro.pdf)


## 2- Tests Unitaires

Lire:  [pdf du cours](doc/cours3TU.pdf) contenant:
- les tests unitaires et leur structuration Given - When - Then
- l'approche partitionnelle: méthode permettant de choisir efficacement les données d'entrées de vos tests.

#### Question 1:
On souhaite tester, dans les classes implémentant l'interface `IPerson`, les deux méthodes `wasBorn` et `getAge`. Vous trouverez la javadoc de ces méthodes dans le fichier _javadoc/index.html_. On ne s'intéresse pas ici à tester les cas où les données d'entrées sont invalides.

Pour les deux méthodes à tester, **réalisez une analyse partitionnelle** en proposant un partitionnement en classes d’équivalence pour chaque donnée d’entrée. **Choisissez et précisez les données de tests et oracles correspondant** pour obtenir les cas de test que vous devrez implémenter dans la suite du TP.


## 3- Tests Unitaires avec JUnit5

![tu](img/Strip-Du-rouge-au-vert-650-final.jpg)


### 3-1 Configuration

Après avoir créé un projet dans IntelliJ à partir de votre dépôt GitHub:
- ajouter les librairies _people.jar_ et _persons.jar_ présentes dans le dossier `libs` à votre projet en suivant [ce lien](https://www.jetbrains.com/help/idea/library.html#define-a-module-library).
- tester en exécutant le fichier `testLib.java` du package `src/testLibraries`. Le dossier `src` doit être défini comme un répertoire source (clic-doit dessus, puis `Marked Directory as`, choisir `Sources Root`).
- ajouter JUnit5 à votre projet en suivant [ce lien](https://www.jetbrains.com/help/idea/testing.html#ij-add-library). Taper dans la barre de recherche `org.junit.jupiter:junit-jupiter:` puis cliquer sur la loupe pour chercher une version disponible.
- marquer le dossier `test` comme un dossier de test en suivant [ce lien](https://www.jetbrains.com/help/idea/testing.html#add-test-root-for-ij)
- tester en exécutant  `TestCalculette.java` de la classe `TestCalculette` (voir [ce lien](https://www.jetbrains.com/help/idea/performing-tests.html#run-tests))


Pour Eclipse et JUnit5, voir [ce lien](https://koor.fr/Java/Tutorial/java_junit5.wp).

### 3-2 Cours
Parcourir ce  [Cours sur JUnit 5](doc/CoursJUnit5.pdf) pour découvrir les différentes fonctionnalités de Junit5.

### 3-3 TP
On souhaite maintenant implémenter des cas de tests pour tester les méthodes de différentes classes implémentant l'interface `IPerson`. Ces cas de tests doivent **couvrir efficacement le domaine d’entrée** de ces méthodes. La classe `persons.Person` est normalement sans erreurs, les classes du package `people` ont toutes au moins une erreur.

#### Question 2:
Pour commencer, on s'intéresse à la classe `persons.Person`. Implémentez les cas de tests définis à la question précédente dans la classe de test `TestPerson`. Exécutez ces cas de tests. **Tous les tests devraient être réussis** (la classe `persons.Person` est normalement sans erreurs).

#### Question 3:
On souhaite maintenant faire passer ces tests aux classes du package `people` qui implémentent l’interface `IPerson` (*donc la classe `people.Personne` n’est pas à tester pour l’instant*).
- Pour cela, **proposez une solution** pour faire passer les cas de tests existants à toutes ces classes sans copier-coller les cas de tests dans chaque classe de test.
- Exécutez vos cas de tests pour chaque classe. **Vous devez avoir au moins un test qui échoue sur chacune des classes du package `people`**. Si ce n’est pas le cas, votre analyse réalisée à la question 1 ne garantie pas une bonne couverture du domaine des données d’entrée. Vous devez donc compléter votre analyse en complétant votre réponse de la question 1 et vos cas de tests et refaire passer tous les tests à toutes les classes qui implémentent l’interface `IPerson` (y compris à `persons.Person`).

## 4- Tests en isolation
Vous allez maintenant utiliser un acteur de substitution, appelé **mocks** (simulacres en français), qui jouera le rôle d'une classe que vous avez besoin d’utiliser. L'intérêt est d'isoler vos tests unitaires.


### 4.1  Configuration 

- ajouter [Mockito](https://site.mockito.org) à votre projet en suivant la méthode donnée en 3.1 pour ajouter JUnit5 (les versions importent peu, prenez les plus récentes) `org.junit.platform:junit-platform-runner:1.1.1`, `org.mockito:mockito-junit-jupiter:3.8.0`, `org.mockito:mockito-core:2.2.21`, `org.junit.jupiter:junit-jupiter-params:5.7.0`
- vérifier en exécutant la méthode `TestMock` de la classe `TestOutilsPersonne`.





### 4-2 Cours


- Lire: [Test en isolation](doc/cours3Mock.pdf)
- Utile: [Javadoc Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)

### 4-3 TP
On souhaite maintenant implémenter et tester des **requêtes** sur des listes de personnes. On veillera à utiliser une interface générique pour représenter les personnes, afin de faciliter l’écriture des tests. On utilisera donc l’interface `IPerson` du package `persons`.


#### Question 4: 
Compléter la classe `OutilsPerson` dans laquelle vous devez:
- implémenter une méthode qui prend en paramètre une liste de `IPerson`, une date au format `GregorianCalendar`, un âge (nombre d’années) minimal et un âge maximal (ce sont des entiers). Cette méthode doit retourner l’ensemble des personnes parmi la liste passée en paramètre dont l’âge à la date donnée est dans l’intervalle [ageminimal,agemaximal]. A titre d’exemple, la méthode pourra être utilisée pour retourner la liste des personnes qui auront entre 60 et 65 ans le 10 mai 2050.
La méthode renverra une exception `IllegalArgumentException `si l’age minimal est supérieur à l’age maximal.
- implémenter une méthode de recherche qui prend en paramètre une liste de `IPerson` et une date au format `GregorianCalendar`. Cette méthode retourne l’âge de la personne la plus âgée parmi la liste à la date donnée en paramètre. Si la liste en entrée est vide, la méthode retournera -1.

#### Question 5:
On souhaite maintenant tester ces deux méthodes en utilisant des instances de `IPerson`. En quoi les objets mock peuvent être utiles dans notre cas ? 


#### Question 6:
Ecrivez des tests unitaires (comportement nominal et aux limites) pour les deux requêtes implémentées aux questions 4 en utilisant le framework Mockito et en complétant la classe `TestOutilsPersonne.java`.

#### Question 7:
On souhaite vérifier par des tests que la 2nde méthode de la question 4 calcule le plus grand âge de façon " anonyme ", c’est-à-dire sans lire les noms et prénoms des personnes ; et en utilisant au moins une fois la méthode `getAge`. Vérifiez ces propriétés à l’aide des mock.
