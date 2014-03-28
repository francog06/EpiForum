profile-- POPULATE CATEGORIES
INSERT INTO category (created, modified, title, description)
VALUES 
(NOW(), NOW(), "EpiForum", "Vous trouverez ici les news, les annonces, de l'aide, les suggestions et une place sur le canapé"),
(NOW(), NOW(), "Programmation", "La programmation dans le domaine informatique est l'ensemble des activités qui permettent l'écriture des programmes informatiques. C'est une étape importante du développement de logiciels."),
(NOW(), NOW(), "Réseau", "Un réseau informatique est un ensemble d'équipements reliés entre eux pour échanger des informations. Par analogie avec un filet, on appelle nœud l'extrémité d'une connexion, qui peut être une intersection de plusieurs connexions ou équipements."),
(NOW(), NOW(), "Sécurité", "La sécurité des systèmes d’information est l’ensemble des moyens techniques, organisationnels, juridiques et humains nécessaire et mis en place pour conserver, rétablir, et garantir la sécurité du système d'information.");

-- POPULATE BOARDS
-- EpiForum
INSERT INTO board (created, modified, categoryId, title, description)
VALUES
(NOW(), NOW(), 1, "News et annonces de EpiForum", "Restez branchés !"),
(NOW(), NOW(), 1, "Astuces et suggestions", "Vous avez un doutes sur le fonctionnement du forum ? C'est par ici !"),
(NOW(), NOW(), 1, "Comme à la maison", "Entrez, c'est ouvert ! On vous à laissé une place. Presentez vous et faites connaissances avec les membres.");

-- Programmation
INSERT INTO board (created, modified, categoryId, title, description)
VALUES
(NOW(), NOW(), 2, "Le C", "Le C est un langage de programmation impératif, généraliste, issu de la programmation système. Inventé au début des années 1970 pour réécrire UNIX, C est devenu un des langages les plus utilisés."),
(NOW(), NOW(), 2, "Le C++", "Le C++ est un langage de programmation permettant la programmation sous de multiples paradigmes comme la programmation procédurale, la programmation orientée objet et la programmation générique."),
(NOW(), NOW(), 2, "Le Python", "Le Python est un langage de programmation objet, multi-paradigme et multi-plateformes. Il est doté d'un typage dynamique fort, d'un ramasse-miettes et d'un système de gestion d'exceptions."),
(NOW(), NOW(), 2, "Le Java", "Le langage Java est un langage de programmation informatique orienté objet, multi-plateformes. Write once, run anywhere !"),
(NOW(), NOW(), 2, "Le PHP", "Le PHP est un langage impératif orienté-objet. Il est principalement utilisé pour produire des pages Web dynamiques via un serveur HTTP, mais pouvant également fonctionner comme n'importe quel langage interprété de façon locale."),
(NOW(), NOW(), 2, "Le Perl", "Le Perl est un langage de programmation reprenant certaines fonctionnalités du langage C et des langages de scripts sed, awk et shell."),
(NOW(), NOW(), 2, "Le Ruby", "Le Ruby est un langage de programmation libre. Il est interprété, orienté objet et multi-paradigme."),
(NOW(), NOW(), 2, "Le C#", "Le C# est un langage de programmation orienté objet à typage fort, créé par la société Microsoft."),
(NOW(), NOW(), 2, "Le JavaScript", "Le JavaScript est un langage de programmation de scripts principalement utilisé dans les pages web interactives mais aussi côté serveur.");

-- Reseau
INSERT INTO board (created, modified, categoryId, title, description)
VALUES
(NOW(), NOW(), 3, "Les réseaux LAN", "LAN de Local Area Network est un réseau informatique tel que les terminaux qui y participent s'envoient des trames au niveau de la couche de liaison sans utiliser d’accès à internet."),
(NOW(), NOW(), 3, "Les réseaux MAN", "MAN de Metropolitan Area Network désigne un réseau composé d'ordinateurs habituellement utilisé dans les campus ou dans les villes."),
(NOW(), NOW(), 3, "Les réseaux WAN", "WAN de Wide Area Network est un réseau informatique couvrant une grande zone géographique, typiquement à l'échelle d'un pays, d'un continent, voire de la planète entière. Le plus grand WAN est le réseau Internet.");

-- Securite
INSERT INTO board (created, modified, categoryId, title, description)
VALUES
(NOW(), NOW(), 4, "La sécurité de l'information", "La sécurité de l'information est un processus visant à protéger des données. Elle s'applique à tous les aspects de la sûreté, la garantie, et la protection d'une donnée ou d'une information, quelle que soit sa forme."),
(NOW(), NOW(), 4, "La sécurité des données", "La sécurité des données est la branche qui s'intéresse principalement aux données, en complément des aspects de traitement de l'information."),
(NOW(), NOW(), 4, "La sécurité des réseaux", "Les technologies de sécurité réseau protègent votre réseau contre les vols et l'utilisation abusive des informations confidentielles et offrent une sécurité contre les attaques malveillantes qui circulent sur Internet."),
(NOW(), NOW(), 4, "La sécurité des applications", "La programmation sécurisée consiste à prendre en compte la sécurité informatique à tous les moments de la conception, de la réalisation et de l'utilisation d'un programme informatique."),
(NOW(), NOW(), 4, "La sécurité physique", "La sécurité physique est la sécurité au niveau des infrastructures matérielles : salles sécurisées, lieux ouverts au public, espaces communs de l'entreprise, postes de travail des personnels etc.");
