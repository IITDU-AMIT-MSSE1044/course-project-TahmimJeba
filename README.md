## Project Description
Qiang Fu et al. proposed a new approach for contextual analysis of system logs for understanding a system’s behaviors. The title of the base paper is “Contextual Analysis of Program Logs for Understanding System Behaviors”. Contextual analysis includes investigating contextual information such as how previous actions are executed by the system, what the historical system states are before running into the state of interest, what the input data is, etc.
The proposed approach follows two main steps: Mining Execution Patterns and Relationships and Learning Essential Contextual Factors.
To learn essential contextual factors that cause a specific branch or path to be executed by the system, the approach consists of two major steps. First, given the log-message groups, Formal Concept Analysis (FCA) is applied to identify execution patterns and build up the lattice graph to model the relationships among execution patterns. Second, from the constructed lattice graph, we extract features from log messages, and apply machine learning techniques to learn essential contextual factors that cause a specific branch or path to be executed by the system.  The learned essential contextual factors can provide useful information for understanding why the system exhibits specific behaviors.

In the FCA generation phase, for transactions of the log are considered as object and log messages are considered as attibutes. I have considered four types of log messages: ERROR, INFO, DEBUG, WARNING. 


## Dataset
I could not manage to find the dataset used in the base paper. I have generated log randomly. The code for log generation is added in the source code.


## Instruction

- Clone and build the project
- First run the LogGenerator.java from the package LogAnalysis.logGenerator to generate log and then run LogParser.java from the same package to make the dataset ready.

- Run RunDecisionTree.java to get final output. 


## Base Paper
http://ieeexplore.ieee.org/document/6624054/
