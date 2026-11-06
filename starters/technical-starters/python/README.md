# Python technical starters

## Pre-req

- [Python 3.15+](https://www.python.org/downloads/) installed on your machine
  - You can use [pyenv](https://github.com/pyenv/pyenv) to jump to different versions
- [uv](https://docs.astral.sh/uv/getting-started/installation/), package and project manager for python installed

## How this project was created

> 🎓 Learning purposes: how these projects were created in case you need to do it again

### Basics

- Create a new project:
```shell
uv init python3.15
```

> 💡 You can fix the python version in `.python-version`, and change the required version in `pyproject.toml`

> 💡 You can also modify the `[project.scripts]` in `pyproject.toml` to match you needs

### Dependencies

- Add some project dependencies
```shell
# Testing
uv add --dev pytest
uv add --dev assertpy

# Linter / Formatter
uv add --dev ruff
```

## Resources

- [uv official documentation](https://docs.astral.sh/uv/)
  - [command reference](https://docs.astral.sh/uv/reference/cli/) 
  - [project setup](https://docs.astral.sh/uv/guides/projects/)

