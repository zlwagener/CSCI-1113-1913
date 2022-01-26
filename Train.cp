#include <iostream>

using namespace std;

class train {
	private:
		string name;
		train* prev;
		train* next;
	public:
		train();
		train(string x);
		bool hasNext();
		bool hasPrevious();
		train* previousTrain();
		train* nextTrain();
		string getName();
		void add(string x);
};

train::train() {
	name = "";
	next = NULL;
	prev = NULL;
}

train::train(string x) { 
	name = x;
	next = NULL;
	prev = NULL;
}
bool train::hasNext() {
	if (next!=NULL) {
		return true;
	}
		return false;
}
bool train::hasPrevious() {
	if (prev!=NULL) {
		return true;
	}
		return false;
}
string train::getName() {
	return name;
}
train* train::previousTrain() {
	return prev;
}
train* train::nextTrain() {
	return next;
}

void train::add(string x) {
	train* choochoo = new train(x);
	if(this -> hasPrevious() == true) {
		prev -> next = choochoo;
}
	choochoo -> prev = prev;
	prev = choochoo;
	choochoo -> next = this;
}
int main()
{
	train engine = train("Engine");
	train* current = &engine;
	string choice;
	do
	{
		if(current -> hasNext())
		{
			cout << "Next train: " << current -> nextTrain() -> getName() << endl;
		}
		
		cout << "Current train: " << current -> getName() << endl;

		if(current -> hasPrevious())
		{
			cout << "Previous train: " << current -> previousTrain() -> getName() << endl;
		}
		
		cout << "Do you wish to go to the (n)ext train, (p)revious train, (a)dd a train, or (q)uit?\n";
		getline(cin,choice);
		if(choice.length() < 1)
		{
			continue;
		}
		
		if(tolower(choice[0]) == 'n' && current -> hasNext())
		{
			current = current -> nextTrain();
		}
		else if(tolower(choice[0]) == 'p' && current -> hasPrevious())
		{
			current = current -> previousTrain();
		}
		else if(tolower(choice[0]) == 'a')
		{
			cout << "Which train is this?\n";
			string name;
			getline(cin, name);
			current->add(name);
		}
		
	}while(tolower(choice[0]) != 'q');

}

