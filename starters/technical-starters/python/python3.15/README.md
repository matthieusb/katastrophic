# Python 3.15 technical starter

## Pre-req

- [Python 3.15+](https://www.python.org/downloads/) installed on your machine
  - You can use [pyenv](https://github.com/pyenv/pyenv) to jump to different versions
- [uv](https://docs.astral.sh/uv/getting-started/installation/), package and project manager for python installed

## Usage

- Synchronize the dev environment:
```shell
uv sync
```

- Run unit tests:
```shell
uv run pytest
```

- Run the project hello-world
```shell
uv run hello-world
```

### Linting / Formatting

- Check for linting and formatting errors:
```shell
uv run check .
```

- Fix linting errors:
```shell
uv run ruff check --fix .
```

- Fix formatting errors:
```shell
uv run ruff format .
```