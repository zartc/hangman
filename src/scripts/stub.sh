#!/usr/bin/bash

SELF=$(which "$0" 2>/dev/null)

if [ -z "$JAVA_HOME" ]; then
  JAVA_CMD=$(which java)
else
  JAVA_CMD="$JAVA_HOME/bin/java"
fi

if [ ! -x "$JAVA_CMD" ] ; then
  echo "No Java Runtime Environment was found" >&2
  echo "A JRE is needed to run this program" >&2
  exit 1
fi

exec "$JAVA_CMD" $java_args -jar "$SELF" "$@"

exit 1

#--- Begin java code ---
