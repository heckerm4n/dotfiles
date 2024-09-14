#!/bin/sh

# xrandr --dpi 120 &
nitrogen --restore &
 picom &
# picom --animations -b &
# dwm vanilla bar

interval=8

## Cpu Info
cpu_info() {
	cpu_load=$(grep -o "^[^ ]*" /proc/loadavg)
	printf "[ $cpu_load%%]"
}

## Memory
  memory() {
  	printf "[ $(free -h | awk '/^Mem/ { print $3 }' | sed s/i//g)]"
  }

## Wi-fi
wlan() {
	case "$(cat /sys/class/net/w*/operstate 2>/dev/null)" in
		up) printf "[ ]" ;;
		down) printf "[󰖪 ]" ;;
	esac
}

## Time
clock() {
	printf "[ $(date '+%a, %I:%M %p')]"
}

## bluetooth


bluetooth(){
    bluetoothctl show | grep -q "Powered: yes" && echo "[]" || echo "[󰂲]"
}

## vloume 
vol(){

    volume=$(pactl list sinks | grep 'Volume:' | head -n 1 | awk '{print $5}' | tr -d '%')

    if [ "$volume" -eq 0 ]; then
        printf "[󰝟 0%%]"
    elif [ "$volume" -le 30 ]; then
        printf "[󰕿 $volume%%]"
    elif [ "$volume" -le 70 ]; then
        printf "[󰖀 $volume%%]"
    else
        printf "[󰕾 $volume%%]"
    fi
}

## Battery Info
battery() {
	BAT=$(cat /sys/class/power_supply/BAT1/capacity)
	AC=$(cat /sys/class/power_supply/ACAD/online)

	if [ "$AC" -eq 1 ]; then
		printf "[ $BAT%%]"
	elif [ "$AC" -eq 1 ] && [ "$BAT" -eq 100 ]; then
		printf "[ Full"
	else
		if [ "$BAT" -ge 0 ] && [ "$BAT" -le 20 ]; then
			printf "[  $BAT%%]"
		elif [ "$BAT" -ge 20 ] && [ "$BAT" -le 40 ]; then
			printf "[  $BAT%%]"
		elif [ "$BAT" -ge 40 ] && [ "$BAT" -le 60 ]; then
			printf "[  $BAT%%]"
		elif [ "$BAT" -ge 60 ] && [ "$BAT" -le 80 ]; then
			printf "[  $BAT%%]"
		elif [ "$BAT" -ge 80 ] && [ "$BAT" -le 100 ]; then
			printf "[  $BAT%%]"
		fi
	fi
}

## Brightness
brightness() {
	LIGHT=$(printf "%.0f\n" `light -G`)

	if [ "$LIGHT" -ge 0 ] && [ "$LIGHT" -le 25 ]; then
		printf "[󰛩 $LIGHT%%]"
	elif [ "$LIGHT" -ge 25 ] && [ "$LIGHT" -le 50 ]; then
		printf "[󱩒 $LIGHT%%]"
	elif [ "$LIGHT" -ge 50 ] && [ "$LIGHT" -le 75 ]; then
		printf "[󱩔 $LIGHT%%]"
	elif [ "$LIGHT" -ge 75 ] && [ "$LIGHT" -le 100 ]; then
		printf "[󰛨 $LIGHT%%]"
	fi
}

## Main
while true; do
  interval=$((interval + 1))

  sleep 1 && xsetroot -name "$(battery) $(brightness) $(cpu_info) $(memory) $(wlan) $(vol) $(clock) $(bluetooth)"
done &

exec dwm
