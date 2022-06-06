# TP Jouons avec les instances en Java

Rapport à rendre dans [Rapport.md](./Rapport.md)

## Le pattern Singleton

Le but de ce premier exercice est d'utiliser la classe `Loggable` pour écrire des variables/objets sur 1 et un unique flux.

Vous aurez réussi cet exercice quand tous les  `Loggable` partageront la même instance de `Logger` (visible par la ref de l'objet Consumer qui doit être unique)
Le `Logger` ne doit pas être passé en paramètre du constructeur d'un `Loggable`.

> Questions :
 - Quel est l'intérêt du Pattern Singleton ?
 - Quel est le cas d'utilisation de ce Pattern ?

## Le static c'est quoi en fait

> Questions :
- Peut-on lire une variable d'instance depuis une fonction static ?
- Peut-on écrire une variable d'instance depuis une fonction static ?
- Peut-on appeler une fonction d'instance depuis une fonction static ?
- Peut-on modifier une variable static depuis une méthode d'instance ?
- Peut-on surcharger une méthode static ?

Implémenter un compteur static qui vous permet de d'associer statiquement le nombre de `Loggable` à un `Logger`.

## Le problème de l'injection de dépendance

Toujours sans passer de paramètre à notre Consumable, on souhaiterait pouvoir configurer quel `Logger` utiliser.

Dans un cas de la vie réelle, en développement, on souhaite que les logs soient écrits dans la console. Alors qu'en production,
on souhaite que cela soit écrit dans un fichier. Ici les deux `Logger` représentent très simplement ce besoin.

On souhaite maintenant pouvoir, au démarrage de l'application, pouvoir injecter le bon `Logger` dans notre `Loggable`.

On rappelera que le Java nécessite une compilation si le code source change.

Notre objectif sera donc de pouvoir configurer efficacement notre application.

## Spring Core, au secours !

**Objectif : Par un fichier de configuration .xml, on souhaite pouvoir configurer quel `Logger` est injecté dans `Loggable`.**

* Première étape : Observer le fichier [./singleton/src/main/resources/spring-config.xml]
* Charger la configuration grâce à Spring Context (`ClassPathXmlApplicationContext` qui vous renvoie un `BeanFactory`).
* Définir un Bean `logger` et lui donner le `ConsoleLogger` en classe dans la configuration xml :
  ```xml
  <bean name="logger" class="logger.ConsoleLogger"/>
  ```
* Récupérer le retour de `beanFactory.getBean("logger")` plusieurs fois, vous devriez avoir un singleton de votre `ConsoleLogger`.
* Tester le `scope="prototype"` pour votre Bean.

> Questions :
 - Qu'est ce qu'un Bean Spring ?
 - Comment pourrait-on décrire simplement le contexte Spring ?
 - Quel est le scope par défaut d'un Bean ?

On va maintenant essayer de charger un Bean abstrait de `Loggable` pour lui injecter le Bean précédement créé :
```xml
<bean name="loggable" class="loggable.Loggable" abstract="true" >
    <property name="logger" ref="logger"/>
</bean>
```

> Questions :
 - À quoi sert le paramètre `abstract`
 - À quoi fait référence `name="logger"` dans la property ?
 - À quoi fait référence `ref="logger"` dans la property ?

On va maintenant créer des beans pour `Person` et `Cat` qui auront comme parent le bean `Loggable` précédemment créé.

Modifier votre `main` pour qu'il construise des beans de `Person` et de `Cat`.

Vous pouvez observer que la class du Bean Logger peut être facilement changée pour utiliser le logger `FileLogger`
sans impact sur votre code.

## Rappel - les annotations en Java

Nous allons essayer de dynamiser la couleur du log par annotations.

On va déclarer une annotation `LogColor` qui prendra une `LoggerUtil.Color` en paramètres.

On rajoutera une analyse de l'annotation pour déterminer la couleur du `ConsoleLogger.log`.

:bulb: La fonction `getAnnotations()` sur une classe devrait vous aider.

Le but va être de customiser par annotation la couleur du log : Rouge pour les personnes et Bleu pour les chats.

> Questions :
 - Expliquez ce qu'est une annotation en Java.
 - Sur quoi peut-on ajouter une annotation en Java ?
 - Les annotations sont-elles utilisées uniquement à la compilation ? au runtime ?

## Optionnel : La même chose avec Spring par annotation

> Questions :
 - Maintenant qu'on a rapidement vu les annotations en Java, à quoi pourraient servir les annotations pour Spring ?
 - À quoi correspond l'`autowiring` par rapport à notre configuration spring précédente ?

Dans un autre module maven (je vous laisse trouver comment setup un sous-module maven), configurer la même application Spring grace à Springboot
et uniquement par annotation et fichier .yml ou .properties. Injecter alors votre Bean Logger par Autowiring.


## Liens utiles

[Bien démarrer son application Spring](https://start.spring.io/)
