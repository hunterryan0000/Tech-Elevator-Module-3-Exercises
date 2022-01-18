# Commands for the Terminal


## File system commands
- `pwd` - Present Working Directory what path am I currently at
- `ls` - Shows what is in the directory
    - `ls -a` shows "hidden" files, generally they begin with a . (i.e. .config, .git)
- `cd` - change directory
    - cd .. - goes up one directory
    - cd <directory name> - goes into the directory by name BUT must be a child of current directory
    - cd <full/absolute path> - goes to the path location 
- `mkdir <directory name>` - makes a new directory
- `touch <file name>` - makes a new file (empty file)
- `rmdir <directory name>` - delete an empty directory by name (delete is permanent)
- `rm <file name>` - remove a file permanently
- `rm -rf <directory name>` - will remove a directory and all its (child) files 

## Git commands

- git status - Tells you the status of your git repository. If you ever wonder what state things are in, this is the command to use.
- git add <file or directory> - This will stage a particular file or all the files in a specified directory
- git add . - This will stage all files in your *current* directory
- git commit -m "some message" - This will commit your changes, making them ready to be pushed
- git push origin main - This will push your commits (on your *main* branch) up to your *origin* or remote repository. 