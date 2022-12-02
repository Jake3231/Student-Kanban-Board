import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, ScrollView, Dimensions } from 'react-native';
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
  color: 'red'
  },
  {
    name: "Systems Programming & Unix",
    courseCode: "CS3377",
    color: 'green'
    }
]

export default function Dashboard({navigation}) {
    return (
        <View style={{flex:1}}>
      <ScrollView contentInsetAdjustmentBehavior="automatic" style={{flexGrow:1, width: Dimensions.get('window').width, marginTop: 10}}>
      <Text style={{fontSize:20, marginLeft: 15}}>In Progress</Text>
      {tasks.map((item) => {
                 if (item.state === TaskState.inProgress) {
                return (
                <TaskCard title={item.title} color={findColorForCourseID(item.class)} />
                )
                 }
              })}
      <Text style={{fontSize:20, marginLeft: 15}}>To Do</Text>
              {tasks.map((item) => {
                 if (item.state === TaskState.toDo) {
                return (
                  <TaskCard title={item.title} color={findColorForCourseID(item.class)} />
                )
                 }
              })}
        <Text style={{fontSize:20, marginLeft: 15}}>Completed</Text>
        {tasks.map((item) => {
                 if (item.state === TaskState.completed) {
                return (
                  <TaskCard title={item.title} color={findColorForCourseID(item.class)} />
                )
                 }
              })}
      </ScrollView>
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