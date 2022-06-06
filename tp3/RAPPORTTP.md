**Nom/Prénom Etudiant :** MARTINEZ Rémi, AUBERT Baptiste

# Rapport TP: Graph et Designs Patterns 

## Question 1
On implémente `getAllNodes()` qui va retourner une `ArrayList` de tout les noeuds.
`getNbNodes` va lui retourner la size de `getAllNodes()` et `getAdjNodes(Node _n)` va permet de retourner une liste de noeud qui ont un arc en commun. Pour le `toString()` on implemente simplement une méthode qui va retourner le graph au format demandé dans l'énoncé.

## Question 2
*Préciser et justifier le design pattern choisi, insérer un diagramme de classes UML de la mise en place de ce pattern dans le contexte de l'exercice, expliquer le code ajouté*

On utilise le design pattern adaptateur en héritant de la classe `Graph` et en implémentant `IUndirectedGraph` pour récupérer les fonctionnalités de `Graph` mais sans implémenter `IDirectedGraph`

![image](https://user-images.githubusercontent.com/28193334/160405534-ef2f39e5-975c-4caf-8668-b7c05e000982.png)

Pour le code ajouté, on a implémenté les méthodes addEdge et hasEdge car pour un graph non orienté nous n'avons plus des arcs mais des arrêtes.
Pour `hasEdge` on regarde les deux arcs possible pour détecter si il existe une arrête.
Pour `addEdge` on créé les deux arcs possible pour ajouter une arrête.

## Question 3
*Expliquer le code ajouté, insérer un diagramme de classes UML de la mise en place du pattern Itérateur dans le contexte de l'exercice, préciser l'intérêt de ce design pattern*

Pour les différents parcours nous avons choisi de créer une classe abstraite `Itérateur` qui va permettre de regrouper les paramètres en commun entre les différents types de parcours.

Pour le parcours en largeur nous avons créer une classe `IterateurLargeur` qui étend la classe `Iterateur` et qui rédifinit la méthode `next()` en fonction de l'algorithme connu du parcours en largeur. Nous utilisons une file (`linkedList<Node>`).

![image](https://user-images.githubusercontent.com/28193334/162213289-143da6f7-6203-4521-8e29-8764416c6b1f.png)

L'intérêt du design pattern Itérateur est que nous pouvons parcourir un même graph avec plusieurs itérateurs simultanément, car chacun possède son propre état d’itération.

## Question 4
*Expliquer le code ajouté, insérer un diagramme de classes UML de votre solution, justifier comment votre solution factorise le comportement commun aux différents algorithmes de parcours. Utilisez-vous dans votre solution d'autres design pattern en plus du pattern Iterateur ? Si oui, précisez lesquels et pourquoi.*

Pour le parcours en profondeur nous avons simplement adapter le code du parcours en largeur en changeant la file d'attente en une pile (`Stack<Node>`).

![image](https://user-images.githubusercontent.com/28193334/162214997-07cd8dd7-ce69-474c-8e2a-49cbf8d0cd92.png)

_Principe de responsabilité unique_: On sépare les algorithmes de parcours dans des classes séparées.

_Principe Open/Close_: On peut implémenter de nouveaux types de collections et d’itérateurs et les utiliser avec le code existant sans rien endommager.
