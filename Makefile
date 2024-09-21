now:
	git status && cat TODO | grcat
draft-push-gh:
	git push gh draft

to-be-done:
	grep -rn TODO composeApp/src > TODO.machine
