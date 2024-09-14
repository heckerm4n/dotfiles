#!/bin/bash

# Color definitions
RESET="\033[0m"
BOLD="\033[1m"
GREEN="\033[32m"
RED="\033[31m"
YELLOW="\033[33m"

# Check if a commit message was provided
if [ "$#" -ne 1 ]; then
    echo -e "${RED}Usage: $0 \"commit message\"${RESET}"
    exit 1
fi

COMMIT_MESSAGE=$1

# Pull the latest changes from the remote repository
echo -e "${YELLOW}Pulling the latest changes from the remote repository...${RESET}"
git pull

# Add all changes to the staging area
echo -e "${YELLOW}Adding changes to the staging area...${RESET}"
git add .

# Commit the changes with the provided commit message
echo -e "${YELLOW}Committing changes with message: ${BOLD}${COMMIT_MESSAGE}${RESET}"
git commit -m "$COMMIT_MESSAGE"

# Push the changes to the remote repository
echo -e "${YELLOW}Pushing changes to the remote repository...${RESET}"
git push

echo -e "${GREEN}Update complete!${RESET}"
