#!/bin/sh

# xrandr --dpi 120 &
nitrogen --restore &
picom &

interval=8

## Colors
green1="#d9fca7"
green2="#6abf4b"
green3="#89e28f"
green_yellow="#c9eb77"
white="#ffffff"
black="#0d1b1b"

## CPU Info
cpu_info() {
    cpu_load=$(grep -o "^[^ ]*" /proc/loadavg)
    printf "^b$green1^^c$black^[ $cpu_load%%]^d^"
}

## Memory Info
memory() {
    printf "^b$green2^^c$black^[ $(free -h | awk '/^Mem/ { print $3 }' | sed s/i//g)]^d^"
}

## Wi-fi Info
wlan() {
    case "$(cat /sys/class/net/w*/operstate 2>/dev/null)" in
        up) printf "^b$green3^^c$black^[ ]^d^" ;;
        down) printf "^b$green_yellow^^c$black^[󰖪 ]^d^" ;;
    esac
}

## Time Info
clock() {
    printf "^b$green2^^c$black^[ $(date '+%a, %b %d, %y (%I:%M %p)')]^d^"
}

## Bluetooth Info
bluetooth() {
    bluetoothctl show | grep -q "Powered: yes" && printf "^b$green1^^c$black^[]^d^" || printf "^b$green1^^c$black^[󰂲]^d^"
}

vol() {
    volume=$(pactl list sinks | grep 'Volume:' | head -n 1 | awk '{print $5}' | tr -d '%')
    volume1=$(pactl get-sink-mute 0 | cut -d: -f2 | awk '{print $1}')
    
    if [ "$volume1" == "yes" ]; then
        printf "^b$green3^^c$black^[󰝟 0%%]^d^"
    elif [ "$volume" -eq 0 ]; then
        printf "^b$green3^^c$black^[󰝟 0%%]^d^"
    elif [ "$volume" -le 30 ]; then
        printf "^b$green3^^c$black^[󰕿 $volume%%]^d^"
    elif [ "$volume" -le 70 ]; then
        printf "^b$green3^^c$black^[󰖀 $volume%%]^d^"
    else
        printf "^b$green3^^c$black^[󰕾 $volume%%]^d^"
    fi
}

## Battery Info
battery() {
    BAT=$(cat /sys/class/power_supply/BAT1/capacity)
    AC=$(cat /sys/class/power_supply/ACAD/online)

    if [ "$AC" -eq 1 ]; then
        printf "^b$green_yellow^^c$black^[ $BAT%%]^d^"
    elif [ "$AC" -eq 1 ] && [ "$BAT" -eq 100 ]; then
        printf "^b$green_yellow^^c$black^[ Full]^d^"
    else
        if [ "$BAT" -ge 0 ] && [ "$BAT" -le 20 ]; then
            printf "^b$green_yellow^^c$black^[  $BAT%%]^d^"
        elif [ "$BAT" -ge 20 ] && [ "$BAT" -le 40 ]; then
            printf "^b$green_yellow^^c$black^[  $BAT%%]^d^"
        elif [ "$BAT" -ge 40 ] && [ "$BAT" -le 60 ]; then
            printf "^b$green_yellow^^c$black^[  $BAT%%]^d^"
        elif [ "$BAT" -ge 60 ] && [ "$BAT" -le 80 ]; then
            printf "^b$green_yellow^^c$black^[  $BAT%%]^d^"
        elif [ "$BAT" -ge 80 ] && [ "$BAT" -le 100 ]; then
            printf "^b$green_yellow^^c$black^[  $BAT%%]^d^"
        fi
    fi
}

## Brightness Info
brightness() {
    LIGHT=$(printf "%.0f\n" light -G)

    if [ "$LIGHT" -ge 0 ] && [ "$LIGHT" -le 25 ]; then
        printf "^b$green1^^c$black^[󰛩 $LIGHT%%]^d^"
    elif [ "$LIGHT" -ge 25 ] && [ "$LIGHT" -le 50 ]; then
        printf "^b$green2^^c$black^[󱩒 $LIGHT%%]^d^"
    elif [ "$LIGHT" -ge 50 ] && [ "$LIGHT" -le 75 ]; then
        printf "^b$green3^^c$black^[󱩔 $LIGHT%%]^d^"
    elif [ "$LIGHT" -ge 75 ] && [ "$LIGHT" -le 100 ]; then
        printf "^b$green_yellow^^c$black^[󰛨 $LIGHT%%]^d^"
    fi
}

## Main Loop
while true; do
    interval=$((interval + 1))

    sleep 1 && xsetroot -name "$(battery) $(brightness) $(cpu_info) $(memory) $(wlan) $(bluetooth) $(vol) $(clock)"
done &



exec dwm
