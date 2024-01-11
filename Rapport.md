# Rapport du Projet - Répartition des Tâches et Justification des Choix

## Répartition des Tâches

Dans le cadre de notre projet, nous avons réparti les tâches au sein de l'équipe de manière à tirer parti des compétences de chaque membre. Voici un aperçu de la répartition des tâches :

- **Aude Halipré** : Responsable de l'implémentation de diverses classes, création des commentaires en anglais pour la Javadoc, gestion des tickets Gitlab.
- **Valentin Damlencourt** : Chargé de développer et d'implémenter de nombreuses classes du projet.
- **Thomas Royer** : En charge de l'implémentation des patrons et des loggers dans le projet, optimisation du code et également implémentation des parsers.
- **Alban Lagragui** : Scrum Master, responsable des issues sur Gitlab et création du diagramme UML complet, aides pour l'implémentation de certaines classes.

Nous avons maintenu une communication ouverte au sein de l'équipe pour partager nos progrès, résoudre les problèmes et s'assurer que le travail était équitablement réparti entre les membres.

## Justification des Choix

### Patron décorateur

Nous avons choisi d'implémenter le patron de conception décorateur pour enrichir les objets avec des fonctionnalités supplémentaires. Cette décision s'est avérée pertinente pour plusieurs raisons :

- **Flexibilité** : Le patron décorateur permet d'ajouter dynamiquement de nouvelles fonctionnalités à un objet existant sans altérer sa structure de base. Cela a été particulièrement utile pour enrichir nos objets avec des capacités spécifiques à l'éclairage et aux rendus.

- **Extensibilité** : En utilisant des décorateurs, nous pouvons ajouter de nouvelles fonctionnalités à tout moment, ce qui a permis d'ajouter des fonctionnalités spécifiques à nos besoins sans modifier les classes de base.

- **Maintenabilité** : La structure modulaire des décorateurs facilite la maintenance du code, car chaque fonctionnalité est encapsulée dans un décorateur distinct. Cela simplifie l'identification et la correction des problèmes.

### Patron Stratégie pour les Parsers

Le patron de conception Stratégie a été choisi pour gérer les parsers et les méthodes d'analyse spécifiques dans notre projet. Cette sélection découle des avantages suivants :

- **Gestion des Parsers** : Les parsers nécessitent une gestion flexible des méthodes d'analyse. Le patron Stratégie offre la possibilité de définir différentes stratégies d'analyse pour les parsers, ce qui s'est avéré essentiel pour notre projet.

- **Facilité d'Extension** : En utilisant le patron Stratégie, nous pouvons ajouter de nouvelles stratégies d'analyse sans altérer le code existant des parsers. Cela garantit une extensibilité du code, ce qui est critique pour gérer différentes sources de données.

- **Maintenabilité** : La séparation des méthodes d'analyse en stratégies distinctes facilite la maintenance, car chaque stratégie peut être développée et testée indépendamment. Cela permet également d'ajouter de nouvelles fonctionnalités d'analyse sans perturber l'existant.

En conclusion, l'utilisation des patrons Décorateur et Stratégie nous a permis de structurer notre code de manière modulaire, flexible et maintenable, tout en répartissant efficacement les tâches au sein de l'équipe. L'utilisation du patron Stratégie spécifiquement pour les parsers a renforcé notre capacité à gérer les méthodes d'analyse de manière efficace, flexible et extensible. Ces choix ont contribué au succès de notre projet en garantissant une gestion efficace de l'enrichissement des objets et de l'analyse du contenu.
