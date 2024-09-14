#!/bin/bash

battery(){
  cmd="$(acpi | cut -d, -f2 | awk '{print $1}' | cut -d% -f1)"
  echo -ne "^b#7daea3^^c#000000^ BATTERY ^d^ $cmd%"
}

volume(){
  cmd="$(pactl get-sink-volume 0 | cut -d/ -f2 | sed -n 1p | awk '{print $1}' | cut -d% -f1)"
  echo -ne "^b#7daea3^^c#000000^ VOLUME ^d^ $cmd%"
}

brightness(){
  cmd="$(sudo ybacklight -get | cut -d. -f1)"
  echo -ne "^b#7daea3^^c#000000^ BRIGHTNESS ^d^ $cmd%"
}

mute(){
  cmd="$(pactl get-sink-mute @DEFAULT_SINK@ | cut -d: -f2 | awk '{print $1}')"
  echo -ne "^b#7daea3^^c#000000^ MUTE ^d^ $cmd"
}

bluetooth(){
	cmd="$(bluetoothctl devices Connected | sed -n 1p)"
  if [ "$cmd" != "" ]; then
    echo -ne "^b#7daea3^^c#000000^ BLUETOOTH ^d^ $cmd"
  fi
}

wifi(){
	cmd="$(nmcli connection | awk '{print $1}' | sed -n 2p)"
  echo -ne "^b#7daea3^^c#000000^ WIFI ^d^ $cmd"
}

arch(){
	cmd="󰣇 ARCHLINUX"
  echo -ne "^c#7daea3^ $cmd^d^"
}

_time(){
  cmd="$(date +'%I:%M %p')"
  echo -ne "^b#7daea3^^c#000000^ TIME ^d^ $cmd"
}

_date(){
  cmd="$(date +'%b %d, %a')"
  echo -ne "^b#7daea3^^c#000000^ DATE ^d^ $cmd"
}

_mem(){
  mem_used="$(top -b -n 1 | grep -i mem | sed -n 1p | awk '{print $8}')"
  mem_total="$(top -b -n 1 | grep -i mem | sed -n 1p | awk '{print $4}')"
  mem_perc_with_extra="$(echo "scale = 4; ($mem_used/$mem_total)*100" | bc)"
  final_mem_perc="${mem_perc_with_extra::-2}%"
  echo -ne "^b#7daea3^^c#000000^ MEM ^d^ $final_mem_perc"
}

_cpu(){
  foo="$(grep 'cpu ' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage "%"}')"
  cmd=${foo::-2}
  cmd="$(echo $cmd | cut -c 1-4)%"
  echo -ne "^b#7daea3^^c#000000^ CPU ^d^ $cmd"
}

xsetroot -name "$(arch) $(_cpu) $(_mem) $(volume) $(battery) $(_time) $(_date) "
