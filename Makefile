now:
	git status && cat TODO
draft-push-gh:
	git push gh draft

to-be-done:
	grep -rn TODO composeApp/src > TODO.machine

start:
	date -R > TIME && git commit TIME -m "time: start stamp"

todo:
	git commit TODO -m "TODO: see"
