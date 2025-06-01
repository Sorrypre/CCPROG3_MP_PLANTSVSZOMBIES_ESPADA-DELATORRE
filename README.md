<a id = "readme-top"> </a>


<!--- Quick Access Buttons--->

[![Contributors][contributors-shield]][contributors-url]
[![Issues][issues-shield]][issues-url]
[![Pull Request][pullRequest-shield]][pullRequest-url]
[![MP Specs][MP-shield]][MP-url]

<!-- DLSU HEADER Image -->
<br />
<div align = "center">
  <a href = "https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE">
    <img src = "https://upload.wikimedia.org/wikipedia/en/thumb/c/c2/De_La_Salle_University_Seal.svg/270px-De_La_Salle_University_Seal.svg.png" alt = "Logo" width = "120" height = "120">
  </a>
  
  <h3 align = "center">CCPROG3 MP ESPADA-DELA TORRE</h3>

  <!--- Please edit approriate links like the linkin of Joramm once finished--->
  <p align = "center">
    The official repository for creating a Java desktop game application derived from the original game called "Plants vs. Zombies". In this game, the objective of the player is to use their limited supply of plants or greens and seeds to prevent a mob of zombies from invading Crazy Dave's home. &#129327;
    <br /> <br /> <br />
    This machine project is created by: <a href = "https://www.linkedin.com/in/joramm-dela-torre-1250b9369/"><b>Joramm Dela Torre</b></a> and <a href = "https://www.linkedin.com/in/jensel-espada-a5a0602a7/"><b>Jensel Espada</b></a> in partial completion of their requirements for the course CCPROG3
    <br /> <br />
      <a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE"><strong>Explore the docs »</strong></a>
      <br />
      <br />
      <a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE">View Demo</a>
      &middot;
      <a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
      &middot;
      <a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<!-- TABLE of Contents -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#about-the-project">About The Project</a>
      <ul>
        <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#getting-started">Getting Started</a>
      <ul>
        <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#prerequisites">Prerequisites</a></li>
        <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#installation-guide-to-local-repo">Installation Guide</a></li>
        <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#commit-and-pull-request-protocols">Commit and Pull Request Protocols</a></li>
      </ul>
    </li>
    <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#roadmap">Roadmap</a></li>
    <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#developer-emails">Developer Emails</a></li>
    <li><a href="https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?tab=readme-ov-file#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- About the Project -->
## About The Project
![Plants Vs. Zombies Sample][PVZ-Sample]
The environment is a board with 5 or 6 lanes, where each lane has 9 to 10 tiles. Each game lasts for 3 minutes. Once the game starts, sun drops at a constant rate. The player can start collecting sun. Once there is enough sun collected, the player can start putting available plants on the tiles. After a few seconds, zombies start to move from one end towards the player's home that is at the other end of the lane. The plants on the lane can eitther attack or defend against the zombies on that lane. At the last few seconds of the game, a wave of zombies storm to the player's home. At level 1, the number of zombies during the wave is 5. This increases by 2 on each level afterwards.

Game ends when either one of the follow condition is satisfied:
* When one zombie reaches the player's home, Zombies win; :zombie: or
* When game time ends, Plants win. :potted_plant:

<p align="right">(<a href="#readme-top">return to Top</a>)</p>

<!-- Programming language used-->
### Built With
* [![Java][Java-shield]][Java-url]

<a href = "https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE">
  <img src = "https://images.vexels.com/media/users/3/166401/isolated/preview/b82aa7ac3f736dd78570dd3fa3fa9e24-java-programming-language-icon.png?w=360" alt = "Logo" width = "70" height = "70">
</a>

<p align="right">(<a href="#readme-top">return to Top</a>)</p>

<!-- Getting started-->
## Getting Started
For this project, `git clone` will be utilized for co-contributors to make changes seamlessly. Constantly, changes are made in the repository by pushing and pulling local commits into the remote. [Git Fork vs. Git Clone](https://youtu.be/6YQxkxw8nhE?si=jdcuqwRFyS532LMA)

### Prerequisites
Make sure you have configured your git version control system properly. Please check by running the prompt below in your terminal. If not installed, follow the installation guide on the official [Git website](https://git-scm.com/).
* Git
  ```sh
  git --version
  ```
  Expected output (or something similiar):
  ```sh
  git version 2.45.2.windows.1
  ```
Ensure that you have at least Java 17 installed in your desktop as stated in the specification requirements of this course. Please check by running the prompt below in your terminal. If not installed, please install in the official [Java oracle website](https://www.oracle.com/ph/java/technologies/downloads/).
* Java
  ```sh
  java -version
  ```
  Expected Output (or something similiar):
  ```sh
  java version "17.0.15" 2025-04-15 LTS
  Java(TM) SE Runtime Environment (build 17.0.15+9-LTS-241)
  Java HotSpot(TM) 64-Bit Server VM (build 17.0.15+9-LTS-241, mixed mode, sharing)
  ```
### Installation Guide To Local Repo

![Screenshot of the code button.](https://docs.github.com/assets/cb-13128/mw-1440/images/help/repository/code-button.webp)
1. Click on the dropdown on the Code button in the github repository to get the HTTPS link of the repo.
2. Copy the link of the repository (or just copy the code below)
   ```sh
   git clone "https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE.git"
   ```
3. Create a folder/directory on your local drive. **Make sure it is _not already tracked_ by `.git`**.
   ```sh
   mkdir <new_target_directory> #you can also create new folders with your system's file mamanger
   ```
4. Go to command prompt and change directory to the created directory.
   ```sh
   cd <new_target_directory>
   ```
5.  Paste `git clone "https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE.git""` to clone the remote to the local repo.
6.  Type `ls` on the terminal to verify the you have the local copy of the remote repository.
7.  Use `git status` to list all new or modified files that haven't yet been committed.

<p align="right">(<a href="#readme-top">return to Top</a>)</p>

<!-- Commit and Pull Request Protocols-->
### Commit and Pull Request Protocols
[![Trunk Base Development][trunkBase-shield]][trunkBase-url]
This project follows a **Trunk Base Development Branching Model**. This strategy uses the main branch as mainline development it is where all developers commit. In this model developers usually clone branches and make changes locally so push them to the mainline (bugfix, feature, etc...). In trunk-based development, the trunk is the central branch (main branch) to which all developers send their code changes. See more [here](https://filipemotta.medium.com/branches-strategies-an-overview-d331c470ec53)

**_Important:_ No commits and pushes are allowed in the main branch.**
1. Before proceeding with any changes to remote, run the following to Avoid Merge Conflicts.
   ```sh
   git status #make sure you are in main
   git switch main #to go to the main branch
   git pull #to pull changes from the remote repository
   git status #to check the head of the current branch (if ahead, behind, or up-to-date)
   ```
2. Creating a new branch for every feature, refactoring, or issue fixes:
   ```sh
   #This combines git switch && git branch to create and switch to the new branch
   git checkout -b <new_branch_name>
   ```

   <!-- Reference for this section: https://gist.github.com/digitaljhelms/4287848-->
   Suggested format of new branch names:

   **##/type/branchName**

   * The `##` represent the branch number
   * The `type` represents the kind of changes made and should be changed to:
       - *feature* - are used when developing a new feature or enhancement which has the potential of a development lifespan longer than a single deployment.
       - *Bugfix* - differ from feature branches only semantically. This will be createdd when there is a bug on the main branch that should be fixed and merged into the next deployment.
       - *hotFix* - comes from the need to act immediately upon an undesired state of the main branch. Additionally, because of the urgency, this branch does not require any merge request from other developers of this project.
    
   * The `branchName` represents the name of the edits/changes done in the branch that will eventually be merged with the main branch.
     

3. Saving work done in the branch and merge request in Github
   ```sh
   #Staging - this puts the change into the staging area where it can be included in the next commit
   git add .

   #Commit - finalizes and saves the changes to your local repo
   git commit -m "<Insert commit message>"
   
   #Push - finalizes and saves the changes to your remote repo
   git push -u origin <##type/branchName>

   ```
4. Merging with main branch
   
   ![See sample of pull request.](https://docs.github.com/assets/cb-87213/mw-1440/images/help/pull_requests/pull-request-review-edit-branch.webp)
   * Go to the Pull requests tab
   * Click on the New pull request button
   * Check if it is able to merge, and it is the branches are correct
   * If merge conflicts are encountered please see this [link](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-using-the-command-line).
   * Addtional info: Click this [link](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request)
     
8. Deleting branches
   
   ![DeleteBranchImage](https://docs.github.com/assets/cb-13465/mw-1440/images/help/branches/branches-delete.webp)
   * On Github, navigate on the main page of the repo
   * select the branch dropdown menu, then click View All branche.
   * Click the trash icon next to the branch you want to delete
   * Deleting a branch associated with at least one open pull request will close the pull request.
   * Read the warnings before deleting

   **For command line terminal deletion:**
  ```sh
  #local repo
  git branch -d <##/type/branchName>

  #remote repo
  git branch origin --delete <##/type/branchName>
  ```

<p align="right">(<a href="#readme-top">return to Top</a>)</p>

## Roadmap
- [x] Feature 1
- [x] Feature 2
- [ ] Feature 3
    - [ ] Fixes
    - [ ] Nested Feature
     
See the [open issues](https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">return to Top</a>)</p>

## Developer Emails
* Joramm Dela Torre - [joramm_delatorre@dlsu.edu.ph](joramm_delatorre@dlsu.edu.ph)
* Jensel Espada - [jensel_john_l_espada@dlsu.edu.ph](jensel_john_l_espada@dlsu.edu.ph)

<p align="right">(<a href="#readme-top">return to Top</a>)</p>

## Acknowledgments
* Ms. Nathalie Lim-Cheng, Professor

<p align="right">(<a href="#readme-top">return to Top</a>)</p>
   
   
<!-- Shield Refs -->
[contributors-shield]: https://img.shields.io/github/contributors/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?style=for-the-badge
[contributors-url]: https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE/graphs/contributors

[issues-shield]: https://img.shields.io/github/issues/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?style=for-the-badge
[issues-url]: https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE/issues

[pullRequest-shield]: https://img.shields.io/github/issues-pr/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE?style=for-the-badge
[pullRequest-url]: https://github.com/Sorrypre/CCPROG3_MP_PLANTSVSZOMBIES_ESPADA-DELATORRE/pulls

[MP-shield]: https://img.shields.io/badge/MP-Specs-brightgreen?style=for-the-badge
[MP-url]: https://drive.google.com/file/d/1gprTeQGyOEtOqirvOlt8kJfeu7j-QuMp/view?usp=sharing

[PVZ-Sample]: https://paragongaming.co.uk/wp-content/uploads/2021/10/81lGSScs7L._AC_SL1500_-1440x895.webp

[Java-shield]: https://img.shields.io/badge/Java-d9973b?style=for-the-badge
[Java-url]: https://www.java.com/en/

[trunkBase-shield]: https://miro.medium.com/v2/resize:fit:1100/format:webp/0*W-GlxosBTAMcvg2V.png
[trunkBase-url]: https://filipemotta.medium.com/branches-strategies-an-overview-d331c470ec53
