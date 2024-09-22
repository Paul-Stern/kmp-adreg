now:
	git status && cat TODO
draft-push-gh:
	git push gh draft

to-be-done:
	grep -rn TODO composeApp/src > TODO.machine

start: 
	date > TIME && git commit TIME -m "time: start stamp"
