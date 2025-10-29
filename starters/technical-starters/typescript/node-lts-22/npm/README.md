# kata typescript starter

## Pre-requisites

You need **node** and **npm** installed

## Installation

Simply run:

```bash
npm install
```

## Development

```bash
npm run compile

# Watch compile
npm run compile:watch
```

Test watch:
```bash
npm run test

# Watch compile
npm run test:watch
```

Coverage:
```bash
npm run coverage
```

See *package.json* scripts for more info.

## Git hooks

There are automatic git hooks triggered before commiting. If you have git hooks already configured. Don't forget to disable them:

```bash
git config --global --unset core.hooksPath
```

