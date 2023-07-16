class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<SkilledPerson> sortBySkills = getPeopleSortedBySkills(people); new ArrayList<>();
        Map<String, Integer> skillMap = getReqSkillMap(req_skills);
        int[][] skilledPeople = getSkilledPeople(sortBySkills, skillMap);
        int[][] presentSkills = getPresentSkills(skilledPeople);
        SufficientTeam team = new SufficientTeam(skillMap.size(), sortBySkills);
        addMembers(0, team, skilledPeople, presentSkills, sortBySkills);
        return team.mostEfficientTeam;
    }

    private List<SkilledPerson> getPeopleSortedBySkills(List<List<String>> people) {
        List<SkilledPerson> sortBySkills = new ArrayList<>();
        int index = 0;
        for (List<String> person : people) {
            if (person.size() > 0) {
                sortBySkills.add(new SkilledPerson(person, index));
            }
            index++;
        }
        sortBySkills.sort((a,b) -> Integer.compare(b.skills.size(), a.skills.size()));
        return sortBySkills;
    }

    private int[][] getPresentSkills(int[][] skilledPeople) {
        int[][] presentSkills = new int[skilledPeople.length][skilledPeople[0].length];
        int[] prev = new int[presentSkills[0].length];
        for (int i = presentSkills.length - 1; i >= 0; i--) {
            for (int j = 0; j < presentSkills[i].length; j++) {
                presentSkills[i][j] = prev[j] + skilledPeople[i][j];
            }
            prev = presentSkills[i];
        }
        return presentSkills;
    }

    private void addMembers(int personIndex, SufficientTeam team, int[][] skilledPeople, int[][] presentSkills, List<SkilledPerson> sortBySkills) {
       if (!team.isFullTeam() && personIndex < skilledPeople.length &&  team.teamSize() < team.mostEfficientTeam.length &&  hasExistingSkills(team, personIndex, presentSkills)) {
            boolean memberAdded = team.addMember(sortBySkills.get(personIndex).originalOrder, skilledPeople[personIndex]);
            if (team.isFullTeam()) {
                if (team.teamSize() < team.mostEfficientTeamSize()) {
                    team.setMostEfficientTeam();
                }
                team.removeMember(skilledPeople[personIndex]);
                return;
            }
            if (memberAdded) {
                addMembers(personIndex + 1, team, skilledPeople, presentSkills, sortBySkills);
            }
            team.removeMember(skilledPeople[personIndex]);
            addMembers(personIndex + 1, team, skilledPeople, presentSkills, sortBySkills);
        }
    }

    private boolean hasExistingSkills(SufficientTeam team, int index, int[][] presentSkills) {
        for (int i = 0; i < team.skills.length; i++) {
            if (team.skills[i] == 0 && presentSkills[index][i] == 0) {
                return false;
            }
        }
        return true;
    }

    private int[][] getSkilledPeople(List<SkilledPerson> people, Map<String, Integer> skillMap) {
        int[][] skilledPeople = new int[people.size()][skillMap.size()];
        for (int i = 0; i < people.size(); i++) {
            for (String skill : people.get(i).skills) {
                skilledPeople[i][skillMap.get(skill)] = 1;
            }
        }
        return skilledPeople;
    }

    private Map<String, Integer> getReqSkillMap(String[] req_skills) {
        Map<String, Integer> skillMap = new HashMap<>();
        for(String skill : req_skills) {
            skillMap.putIfAbsent(skill, skillMap.size());
        }
        return skillMap;
    }

    private static class SkilledPerson {
        public List<String> skills;
        int originalOrder;

        public SkilledPerson(List<String> skills, int originalOrder) {
            this.skills = skills;
            this.originalOrder = originalOrder;
        }
    }

    private static class SufficientTeam {
        private final int[] skills;
        private final LinkedList<Integer> team;
        private int coveredSkills;
        private int[] mostEfficientTeam;

        public SufficientTeam(int numberOfSkills, List<SkilledPerson> sortBySkills) {
            skills = new int[numberOfSkills];
            mostEfficientTeam = new int[sortBySkills.size()];
            for (int i = 0; i < mostEfficientTeam.length; i++) {
                mostEfficientTeam[i] = sortBySkills.get(i).originalOrder;
            }
            team = new LinkedList<>();
        }

        public boolean isFullTeam() {
            return skills.length == coveredSkills;
        }

        public int teamSize() {
            return team.size();
        }

        public boolean addMember(int index, int[] person) {
            boolean newSkillAdded = false;
            team.addLast(index);
            for (int i = 0; i < person.length; i++) {
                if(person[i] == 1 && ++skills[i] == 1) {
                    newSkillAdded = true;
                    coveredSkills++;
                }
            }
            return newSkillAdded;
        }

        public void removeMember(int[] person) {
            for (int i = 0; i < person.length; i++) {
                if (person[i] == 1 && --skills[i] == 0) {
                    coveredSkills--;
                }
            }
            team.removeLast();
        }

        private int mostEfficientTeamSize() {
            return mostEfficientTeam.length;
        }

        public void setMostEfficientTeam() {
            mostEfficientTeam = new int[team.size()];
            int index = 0;
            for (int member : team) {
                mostEfficientTeam[index++] = member;
            }
        }
    }
}