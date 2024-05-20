<%@ page pageEncoding="UTF-8" %>

<!-- page help -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d'Aide - Service REST cv24</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="intro">
    <h1>Service REST cv24 - Aide</h1>
    <p>Bienvenue sur la page d'aide du service REST cv24. Vous trouverez ci-dessous la liste des opérations disponibles.</p>
</div>
<table>
    <thead>
    <tr>
        <th scope="col">URL</th>
        <th scope="col">Méthode HTTP</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td colspan="3" style="text-align: center;">Projet Web 2 - 2023/2024</td>
    </tr>
    </tfoot>
    <tbody>
    <tr>
        <th scope="row">/</th>
        <td>GET</td>
        <td>Retourne la page d'accueil avec un message identifiant le projet</td>
    </tr>
    <tr>
        <th scope="row">/help</th>
        <td>GET</td>
        <td>Retourne la liste des opérations gérées par le service REST</td>
    </tr>
    <tr>
        <th scope="row">/cv24/resume/xml</th>
        <td>GET</td>
        <td>Retourne la liste des CV stockés au format XML</td>
    </tr>
    <tr>
        <th scope="row">/cv24/resume</th>
        <td>GET</td>
        <td>Retourne la liste des CV stockés au format HTML</td>
    </tr>
    <tr>
        <th scope="row">/cv24/xml?id={id}</th>
        <td>GET</td>
        <td>Retourne le contenu complet du CV dont l’identifiant est spécifié au format XML</td>
    </tr>
    <tr>
        <th scope="row">/cv24/html?id={id}</th>
        <td>GET</td>
        <td>Retourne le contenu complet du CV dont l’identifiant est spécifié au format HTML</td>
    </tr>
    <tr>
        <th scope="row">/cv24/insert</th>
        <td>POST</td>
        <td>Ajoute un nouveau CV à la base de données</td>
    </tr>
    <tr>
        <th scope="row">/cv24/delete</th>
        <td>DELETE</td>
        <td>Supprime un CV de la base de données</td>
    </tr>
    </tbody>
</table>
</body>
</html>
