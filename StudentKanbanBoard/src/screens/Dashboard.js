import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, ScrollView, Dimensions, SectionList } from 'react-native';
import {
  SafeAreaView,
  SafeAreaProvider,
  SafeAreaInsetsContext,
  useSafeAreaInsets,
  initialWindowMetrics,
} from 'react-native-safe-area-context';
import TaskCard from '../components/TaskCard'

const TaskState = { inProgress: 'InProgress', completed: 'Completed', toDo: 'ToDo'};

const tasks = [
  {
    title: "Project Phase 5",
    class: "CS3354",
    state: TaskState.inProgress
  },
  {
    title: "Project Phase 4",
    class: "CS3354",
    state: TaskState.completed
  },
  {
    title: "Project Phase 3",
    class: "CS3354",
    state: TaskState.completed
  },
  {
    title: "Project Phase 6",
    class: "CS3354",
    state: TaskState.toDo
  },
  {
    title: "Unix Exam",
    class: "CS3377",
    state: TaskState.toDo
  }
];

const courses = [
  {
  name: "Software Engineering",
  courseCode: "CS3354",
  color: 'rgba(255,0,0,0.5)'
  },
  {
    name: "Systems Programming & Unix",
    courseCode: "CS3377",
    color: 'rgba(0,255,0,0.5)'
    }
]

export default function Dashboard({navigation}) {
    return (
        <View style={{flex:1}}>
          <SectionList
      sections={[{title: "In Progress", data: tasks.filter(task => task.state === TaskState.inProgress)}, {title: "To Do", data: tasks.filter(task => task.state === TaskState.toDo)}, {title: "Completed", data: tasks.filter(task => task.state === TaskState.completed)}]}
      keyExtractor={(item, index) => item + index}
      renderItem={({ item }) => <TaskCard title={item.title} color={findColorForCourseID(item.class)} />}
      renderSectionHeader={({ section: { title } }) => (
        <Text style={{fontSize:20, marginLeft: 15, fontWeight:'600', marginBottom:5}}>{title}</Text>
      )}
    />
        <StatusBar style="auto" />
        </View>
    );

    function findColorForCourseID(courseCode) {
      const result = courses.find((element) => {
        return element.courseCode === courseCode;
      })
      if (result === undefined) {
        return 'yellow'
      }
      return result.color
    }
  }