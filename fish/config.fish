if status is-interactive
    # Commands to run in interactive sessions can go here
    set fish_greeting
    alias nv="nvim"
    alias ls="exa --icons"
    alias ll="exa -lah --icons --color=always --group-directories-first -F"
    alias tree="exa --tree --icons"
    # alias where="which"
    # alias install="sudo pacman -S"
    # alias update="sudo pacman -Syu"
    alias enable="systemctl enable"
    alias start="systemctl start"
    alias disable="systemctl disable"
    # alias uninstall="sudo pacman -R"
    alias faf="fastfetch --logo-width 45 --logo-height 26 --logo cypher.png"
end
