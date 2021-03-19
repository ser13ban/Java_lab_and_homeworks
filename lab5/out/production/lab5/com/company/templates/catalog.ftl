<html>
<head>
    <title>${title}</title>
</head>
<body style="display: flex; justify-content: center; align-items: center; flex-direction: column; background: aqua; font-size: xx-large">
<h1>${title}</h1>
<p>The items from the catalog are: </p>
<ul>
    <#list systems as system>
        <li>${system_index + 1}. ${system.name} from ${system.path}</li>
    </#list>
</ul>
</body>
</html>