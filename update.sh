#!/bin/bash

# Check if a commit message was provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 \"commit message\""
    exit 1
fi

COMMIT_MESSAGE=$1

# Pull the latest changes from the remote repository
echo "Pulling the latest changes from the remote repository..."
git pull

# Add all changes to the staging area
echo "Adding changes to the staging area..."
git add .

# Commit the changes with the provided commit message
echo "Committing changes with message: $COMMIT_MESSAGE"
git commit -m "$COMMIT_MESSAGE"

# Push the changes to the remote repository
echo "Pushing changes to the remote repository..."
git push

echo "Update complete!"
