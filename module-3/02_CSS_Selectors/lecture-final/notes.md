# CSS Selectors

CSS can go in many places in your project...
- in-line in HTML
- `<style>` tag in HTML
- separate CSS file 

BUT you should really *always* keep it all in your CSS file.

Separation of Concerns - Keep the presentation separate from the structure & content.
[CSS Zen Garden](http://www.csszengarden.com/)

## Types of Selectors

- **Selectors**

  - universal - (*) selects all elements
  - element - HTML tag name - selects all HTML elements with that tag on a page
  - id - specific to a single element - an ID must be unique on a given page
  - class - applied to HTML elements with the class attribute. Can be any number or type of elements.
  - descendant combinator
    - descendant selector (space)
    - child selector (>)
    - adjacent sibling selector (+)
    - general sibling selector (~)
  - pseudo-class (for example, `a:hover`)