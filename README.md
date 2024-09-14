# DWM

## For Display Manager
`Location: '/usr/share/xsessions/dwm.desktop'`
```bash
[Desktop Entry]
Encoding=UTF-8
Name=dwm
Comment=Dynamic Window Manager
Exec=/usr/local/bin/dwm
Icon=dwm
Type=XSession
```
## Touchpad Gestures
`Location: '/etc/X11/xorg.conf.d/30-touchpad.conf'`
```bash
Section "InputClass"
    Identifier "touchpad"
    Driver "libinput"
    MatchIsTouchpad "on"
    Option "Tapping" "on"
    Option "TappingButtonMap" "lrm"
    Option "NaturalScrolling" "true"
EndSection
```
## To make laptop Sleep

To make laptop Sleep on Lid Close & Power Button uncomment these lines from `Location: '/etc/systemd/logind.conf'`
```
HandleLidSwitch=suspend
HandlePowerKey=suspend
HandlePowerKerLongPress=poweroff
```
## For grub

if you installed grub you can not see windows bootlodar 'cause they are in different prtitions so you can mount any directory of arch in the efi partition of arch

