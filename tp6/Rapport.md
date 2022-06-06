# Rapport TP Jouons avec les instances en Java

Nom Etudiant 1: Baptiste AUBERT  
Nom Etudiant 2: Rémi MARTINEZ

## Pattern Singleton
Quel est l'intérêt du Pattern Singleton ?
Quel est le cas d'utilisation de ce Pattern ?

> Questions :
- Quel est l'intérêt du Pattern Singleton ?

Le Singleton est un patron de conception de création qui s’assure de l’existence d’un seul objet de son genre et fournit un unique point d’accès vers cet objet.  
Il permet de garantir l'unicité d'une instance pour une classe, et de fournir un point d'accès global à cette instance.

- Quel est le cas d'utilisation de ce Pattern ?

1. Quand on veut contrôler l'accès à une ressource partagée (comme une base de données ou un fichier par exemple).  
2. Quand on veut accéder à l'objet n'importe où dans le programme tout en protégeant l'instance d'être modifiée  

## Static

> Questions :
- Peut-on lire une variable d'instance depuis une fonction static ?
  - Non, car il faut crée une _instance_ de la classe pour initialiser une variable d'instance or la fonction static accède simplement à la _classe_ 
- Peut-on écrire une variable d'instance depuis une fonction static ?
  - Non, pour la même raison. 
- Peut-on appeler une fonction d'instance depuis une fonction static ?
  - Non, on ne peut pas appeler de fonction d'instance dans une fonction static hormis le constructeur qui est un cas particulier 
- Peut-on modifier une variable static depuis une méthode d'instance ?
  - Oui, il est en effet possible de modifier une variable static depuis une méthode d'instance
- Peut-on surcharger une méthode static ?
  - Il est possible de surcharger une méthode static mais pas de la redéfinir

## Spring Core

> Questions :
- Qu'est ce qu'un Bean Spring ?

C'est une classe qui est lancée en même temps que le framework Spring.  
L'objet sera instancié, assemblé et géré par Spring directement.

- Comment pourrait-on décrire simplement le contexte Spring ?



- Quel est le scope par défaut d'un Bean ?

Le scope par défaut d'un Bean est le Singleton.  
Ce scope implique que le conteneur Spring créera une seule instance partagée de la classe désignée par ce Bean,
ainsi à chaque fois que le Bean sera requis, le même objet sera injecté.

On va maintenant essayer de charger un Bean abstrait de `Loggable` pour lui injecter le Bean précédement créé :
```xml
<bean name="loggable" class="loggable.Loggable" abstract="true" >
    <property name="logger" ref="logger"/>
</bean>
```

> Questions :
- À quoi sert le paramètre `abstract`

Le paramètre `abstract` permet dans la définition des beans du fichier xml de le définir comme bean "parent" afin de ne
pas avoir à répéter des propriétés communes avec ses enfants.

- À quoi fait référence `name="logger"` dans la property ?

`name="logger"` fait référence au nom d'une des propriétés dans le Bean qui sera instancié

- À quoi fait référence `ref="logger"` dans la property ?

`ref="logger"` fait référence au Bean portant le nom "logger"

## Annotations

> Questions :
- Expliquez ce qu'est une annotation en Java.  
  - Les annotations Java sont utilisées pour fournir des métadonnées incluses dans le code source. Ces métadonnées
  associés aux entités Java peuvent être exploitées à la compilation ou à l'exécution.
  

- Sur quoi peut-on ajouter une annotation en Java ?
  - packages
  - classes
  - interfaces
  - constructeurs
  - méthodes
  - champs
  - paramètres
  - variables
  - annotations elles-mêmes
  

- Les annotations sont-elles utilisées uniquement à la compilation ? au runtime ?
  - Les deux sont possibles. On peut forcer l'execution au runtime avec `@Retention(RetentionPolicy.RUNTIME)` 

## Spring avec annotations

> Questions :
- Maintenant qu'on a rapidement vu les annotations en Java, à quoi pourraient servir les annotations pour Spring ?
  - Pour Spring, les annotations peuvent servir à des fins de configurations (`@Configuration`). Notamment configuration du framework Spring
  au démarrage, configuration des CORS dans le cas d'une API, etc.

- À quoi correspond l'`autowiring` par rapport à notre configuration spring précédente ?
  - Avec Spring l'annotation `@Autowired` active l'injection automatique de dépendances.
