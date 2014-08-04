#!/bin/sh
BINDIR=$(dirname "$(readlink -fn "$0")")
cd "$BINDIR"
screen -S bukkit -d -m java -Xmx1024M -jar craftbukkit-1.7.9-R0.2.jar
