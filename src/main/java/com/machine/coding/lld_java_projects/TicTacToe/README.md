# Tic Tac Toe (LLD)

## Problem Statement

Design and implement a Tic Tac Toe game that allows two players to play on a NxN board, alternating turns, and determines the winner or a draw.

---

## Requirements

- **Two Players:** The game is played between two players.
- **Board:** The game uses a NxN board.
- **Turns:** Players take turns to place their symbol (X or O) on the board.
- **Win Condition:** The game detects when a player has won (three in a row, column, or diagonal).
- **Draw Condition:** The game detects when the board is full and the game is a draw.
- **Input Validation:** The game prevents moves to already occupied cells.
- **Extensibility:** Easy to change the board size or add new features.

---

## Core Entities

- **Game:** Manages the game flow, player turns, and game status.
- **Board:** Represents the NxN grid and provides methods to update and check the board.
- **Cell:** Represents a single cell on the board.
- **Player:** Represents a player with a name and symbol.
- **Symbol:** Enum for X and O.
- **GameStatus:** Enum for IN_PROGRESS, DRAW, WIN.

---

## Extending the Design

- **Change board size:** Update the `Board` class to support different sizes.
- **Add AI player:** Implement a computer player for single-player mode.
- **Add GUI:** Build a graphical interface for the game.

---