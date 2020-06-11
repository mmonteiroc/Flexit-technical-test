# Frontend

Please, understand that this readme only reffers to the frontend project, if you wanna use the full project with the database and the backend
go to the [readme](https://github.com/mmonteiroc/Flexit-technical-test/blob/master/README.md)


## Development server

Run `ng serve` or `npm run start` for a dev server. Navigate to `http://localhost:4200/`. 


# Docker
## Download
You can find the image of this project at my dockerhub repo or executing ``docker pull mmonteiroc/front-flexit``
## Or you can build your own image
Run ``npm i`` to install all the dependencies inside this project.

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. 

Then just need to execute ```docker build -t front-flexit .  &&  docker run -d -p 80:80 front-flexit`` and you gonna have at http://localhost listening the project of frontend

