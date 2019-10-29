The Liferay Learn documentation site is built using [Sphinx](http://www.sphinx-doc.org/en/master/). The templates, styles, and javascript are in the `/sphinx/homepage/` directory and propagated to the `/sphinx/docs/` directory that later get compiled into static html pages.

## Getting Started

1. [Install node](https://nodejs.org/en/).
2. Install all dependencies with `npm install` in the `sphinx/homepage/` directory.
3. If you would like to take advantage of live update, install autobuild with `pip install sphinx-autobuild`.

## Build

To build `main.css` and propagate assets, run `npm run build`.

To leverage live update for theme changes, run `sphinx-autobuild ${path/to/sphinx/homepage/directory} build/output/homepage`. The output will be served on `http://127.0.0.1:8000/`.