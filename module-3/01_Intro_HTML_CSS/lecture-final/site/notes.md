# HTML / CSS

Client-side / Front-end 
    - Hosted from a web server, but they are not "back-end" or server-side technologies
    - HTML - like a skeleton or foundation 
    - CSS - like the skin or clothing that makes it all pretty or look a certain way
    - JS (coming soon) - like the muscles that make it interactive, dynamic & functional

> IMPORTANT - The client code (starting now) will be built & run through VS Code. We will still run our Java server code in IntelliJ.
> To open your web page, right-click on the HTML file and select "Open with Live Server"


## Site structure

- Usually has an `index.html` page that is the main page or starting point of the application.

### HTML Structure
Tree-like, hierarchical structure with parent/child/sibling relationships:
  - `<html>`: The "root" element. Every other element on the page should be a "descendant" of this element, meaning it's nested underneath, like a folder inside another folder.
  - Has two child elements:  `<head>` and `<body>`
    - head - not visual stuff, no "page content", metadata (information about the page itself), used by the browser to show the page
    - body - visual stuff, this is what someone sees/interacts with when the view the page in the browser

The browser is super forgiving on HTML structure. If it can show the page (even if the HTML is "bad") it will. 
To get error messages, validate the HTML: https://validator.w3.org/nu/#file

HTML Reference: https://www.w3schools.com/tags/default.asp

## CSS

Fonts: 
- [CSS Font Stack](https://www.cssfontstack.com/) - It's a little dated, but has a nice list of both web safe & web fonts.
- [Google Fonts](https://fonts.google.com/) - Has A LOT of web fonts to make your web sites super cool.

Web fonts require you to link to the font on the web. 
Web safe fonts rely on the font being installed on the users computer. You should specify a fall back list in case the font is not there.