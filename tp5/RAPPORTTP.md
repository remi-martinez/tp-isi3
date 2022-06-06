**Nom/Prénom Etudiant  :**



# Rapport TP Tests 

### Question 1: analyse partitionnelle
#### Préciser différentes versions de votre analyse si votre première partition n'a pas été concluante (n'a pas permis de trouver toutes les erreurs dans toutes les classes)
- Version 1
  - `wasBorn` : deux paramètres
    - date de naissance `birthDate`
    - Une autre date de type `GregorianCalendar` pour comparer
    - Pour le test
      - => Le test passe si les deux dates sont égales.
  - `getAge` : deux paramètres
    - date de naissance `birthDate`
    - âge
    - Pour le test
      - => tester que l'âge de la personne correspond bien à sa date de naissance
      - => la personne a bien `0` an le jour de sa naissance
      - => une erreur quand on demande l'âge d'une personne avec une date de naissance postérieure à la date du jour
  
  
- Version 2
  - `wasBorn`
    - née le jour de sa naissance : `true`
    - née avant aujourd'hui : `true`
    - déjà née un jour avant sa naissance : `false`
    - déjà née un jour après sa naissance : `true` 
    - déjà née un mois avant sa naissance : `false`
    - déjà née un mois après sa naissance : `true`
    - déjà née un an avant sa naissance : `false`
    - déjà née un an après sa naissance : `true`
  - `getAge`
    - âge personne correspond à sa date de naissance
    - test de l'âge un jour avant anniversaire
    - test de l'âge un jour après anniversaire
    - 0 an le jour de sa naissance
    - throw une erreur si la personne n'est pas encore née (âge négatif impossible)

#### Question 5:
On souhaite maintenant tester ces deux méthodes en utilisant des instances de `IPerson`. En quoi les objets mock peuvent être utiles dans notre cas ? 

Les objets mock vont être utiles ici car on va venir mocker `OutilsPersonne` comme s'il s'agissait d'un service.
On va venir construire un "faux objet" et on va lui décrire comment il doit se comporter quand on ne dispose pas d’une
implémentation de l’interface dont nous avons besoin adaptée au contexte du test, ce qui est notre cas ici (plusieurs 
contextes différents avec `People`, `Person`, `IPerson`, ...)

NB : pour la question 7 le test Anonymous ne marche pas





