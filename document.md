## How to test code
1. Either use the url (with adjusted port) in as per readme.md
   1. [Create 1st Rower](http://127.0.0.1:8080/rover/create?direction=E&x=3&y=5)
   2. [Create 2nd Rower](http://127.0.0.1:8080/rover/create?direction=E&x=3&y=5)
   3. [Navigate first rovers](http://127.0.0.1:8080/rover/navigate?id=1&commands=F,L,F,R,F)
   4. [Navigate one of the rovers](http://127.0.0.1:8080/rover/navigate?id=1&commands=F,F,F,R,F)
2. Or use the web - page with developer console for the network activity
   1. Create few random rovers
   2. ![Create random rovers](./src/main/md/CreateRandomRovers.png "Creation")
   3. ![Move 3rd rover](./src/main/md/3rdRover1stMove.png "Navigate")
   4. ![Move 2nd rover](./src/main/md/3rdRover2ndMove.png "Navigate")


## Note
1. Html and javascript has lots of bug, it is poorman debug tool
   1. We can use network tab on devtools if required
2. Textarea will be keep appended to compare with prior result
3. We can delete text inside textarea for future API result alone