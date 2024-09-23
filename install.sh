#!/bin/bash

# Define colors for the script output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}=> UPDATING SYSTEM${NC}"
sudo pacman --noconfirm -Syu

echo -e "${YELLOW}=> INSTALLING XORG${NC}"
sudo pacman --noconfirm -S xorg-server xorg-xinit xorg-xrandr xorg-xsetroot xorg-xrdb xorg-xinput

echo -e "${YELLOW}=> INSTALLING NVIDIA DRIVERS${NC}"
sudo pacman --noconfirm -S nvidia nvidia-settings nvidia-utils

echo -e "${YELLOW}=> INSTALLING IMPORTANT PROGRAMS${NC}"
sudo pacman --noconfirm -S git vim tmux fish neovim kitty neofetch bashtop exa bat fd fzf lxappearance nitrogen dunst firefox firefox-developer-edition discord xcolor thunar gvfs rofi ly keyd starship xclip tldr qutebrowser make clang gcc unzip zip pdfarranger xournalpp yt-dlp nodejs npm dmenu perl-image-exiftool

# Check if paru is installed, if not install it
if ! command -v paru &> /dev/null; then
    echo -e "${RED}paru is not installed. Installing paru...${NC}"
    sudo pacman --noconfirm -S base-devel
    git clone https://aur.archlinux.org/paru.git
    cd paru && makepkg -si --noconfirm
    cd .. && rm -rf paru
else
    echo -e "${GREEN}paru is already installed.${NC}"
fi

# Prompt user if dwm is installed
read -p "Is dwm installed? (y/N): " dwm_response
dwm_response=${dwm_response:-N}  # Default to "N" if the user presses enter

if [[ "$dwm_response" =~ ^[Nn]$ ]]; then
    echo -e "${YELLOW}=> Installing dwm${NC}"
    paru -S --noconfirm dwm dmenu
else
    echo -e "${GREEN}dwm is already installed or will not be installed.${NC}"
fi

# Install packages from AUR using paru
echo -e "${YELLOW}=> INSTALLING AUR PACKAGES${NC}"
paru -S --noconfirm picom-ftlabs-git ttf-jetbrains-mono-nerd noto-fonts-emoji spotify stremio betterlockscreen visual-studio-code-bin python-adblock

# Install GTK themes, icon packs, and cursor themes
echo -e "${YELLOW}=> INSTALLING GTK THEMES, ICONS, AND MOUSE CURSORS${NC}"
paru -S --noconfirm adwaita-dark arc-gtk-theme papirus-icon-theme breeze-gtk breeze-icons breeze-cursor-theme qt5ct

# Final installation complete message
echo -e "\n${GREEN}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SYSTEM SETUP COMPLETE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<${NC}"
