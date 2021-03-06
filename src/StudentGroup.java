import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	private Student[] students2;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		// if(this.students==null)
		// 	return null;
		int nullCount=0;
		int length=this.students.length;
		for(int i=0;i<length;i++){
			if(this.students[i]==null)
				nullCount++;
		}
	
		if(nullCount==length)
			this.students=new Student[0];
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		int length=students.length;
		int temp=1;
		
		int nullCount=0;
		for(int i=0;i<students.length;i++){
			if(students[i]==null)
				nullCount++;
		}
		this.students=new Student[length-nullCount];
		int count=0;
		for(int i=0;i<students.length;i++){
			if(students[i]!=null)
				this.students[count++]=students[i];
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<=0 || index>=this.students.length )
			throw new IllegalArgumentException();
		else if(this.students[index]==null)
			return null;
		else
			return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null || index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
			this.students[index]=student;


		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null){
			throw new IllegalArgumentException();
		}
		else{
				int length=this.students.length;
				this.students2=new Student[length+1];
				int count2=0,k;
				this.students2[count2++]=student;
				for(k=0;k<length;k++){
					if(this.students[k]!=null)
						this.students2[count2++]=this.students[k];
				}	
				this.students=new Student[length+1];
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}
	

	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null){
			throw new IllegalArgumentException();
		}
		else{
				int length=this.students.length;
				this.students2=new Student[length+1];
				int count2=0,k;
				for(k=0;k<length;k++){
					if(this.students[k]!=null)
						this.students2[count2++]=this.students[k];
				}	
				this.students2[count2++]=student;
				this.students=new Student[length+1];
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}

	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null || index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
				int length=this.students.length;
				this.students2=new Student[length+1];
				int count2=0,k;
				for(k=0;k<length;k++){
					if(k==index){
						this.students2[count2++]=student;
						break;
					}
					else{
						if(this.students[k]!=null)
							this.students2[count2++]=this.students[k];
					}
				
				}
				for(int p=k;p<length;p++){
					this.students2[count2++]=this.students[p];
				}

				this.students=new Student[length+1];
				//int count=0;
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
				int length=this.students.length;
				if(length-1>=0)
					this.students2=new Student[length-1];
				int count2=0,k;
				for(k=0;k<length;k++){
					if(k==index){
						//this.students2[count2++]=student;
						k++;
						break;
					}
					else{
						if(this.students[k]!=null)
							this.students2[count2++]=this.students[k];
					}
				
				}
				for(int p=k;p<length;p++){
					this.students2[count2++]=this.students[p];
				}

				this.students=new Student[length-1];
				//int count=0;
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}	
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int i;
			for(i=0;i<this.students.length;i++){
				if(this.students[i]==student)
					break;
			}
			if(i==this.students.length){
				throw new IllegalArgumentException("Student not exist");
			}
			else{
				this.students2=new Student[this.students.length-1];
				int count=0,j;
				for(j=0;j<this.students.length;j++){
					if(this.students[j]==student)
						break;
					if(this.students[j]!=null)
						this.students2[count++]=this.students[j];
				}
				for(i=j+1;j<this.students.length;j++){
					this.students2[count++]=this.students[i];
				}
				this.students=new Student[this.students.length-1];
				for(i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
				int length=this.students.length;
				if(length-(length-index-1)>=0)
					this.students2=new Student[length-(length-index-1)];
				int count2=0,k;
				for(k=0;k<length;k++){
					if(k==index){
						this.students2[count2++]=this.students[k];
						k++;
						break;
					}
					else{
						if(this.students[k]!=null)
							this.students2[count2++]=this.students[k];
					}
				
				}
				// for(int p=k;p<length;p++){
				// 	this.students2[count2++]=this.students[p];
				// }

				this.students=new Student[length-(length-index-1)];
				//int count=0;
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}

	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
				int length=this.students.length;
				int count2=0,k;
				for(k=0;k<length;k++){
					if(this.students[k]==student){
						break;
					}
				}
				this.students2=new Student[length-(length-k-1)];
				int temp=k;
				for(k=0;k<length;k++){
					if(k==temp){
						this.students2[count2++]=this.students[k];
						k++;
						break;
					}
					else{
						if(this.students[k]!=null)
							this.students2[count2++]=this.students[k];
					}
				
				}

				this.students=new Student[length-(length-temp-1)];
				//int count=0;
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
				int length=this.students.length;
				if(length-index>=0)
					this.students2=new Student[length-index];
				int count2=0,k;
				for(k=0;k<length;k++){
					if(k>index){
						if(this.students[k]!=null)
							this.students2[count2++]=this.students[k];
					}
				
				}
				// for(int p=k;p<length;p++){
				// 	this.students2[count2++]=this.students[p];
				// }

				this.students=new Student[length-index];
				//int count=0;
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}

		
		

	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
				int length=this.students.length;
				int count2=0,k;
				for(k=0;k<length;k++){
					if(this.students[k]==student){
						break;
					}
				}
				if(length-k>=0)
				this.students2=new Student[length-k];
				int temp=k;
				for(k=0;k<length;k++){
					if(k>temp){
						if(this.students[k]!=null)
							this.students2[count2++]=this.students[k];
					}
				
				}

				this.students=new Student[length-temp];
				//int count=0;
				for(int i=0;i<this.students2.length;i++){
					this.students[i]=this.students2[i];
				}
			}

		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int i,j;
		Student st;
		for(i=0;i<this.students.length-1;i++){
			for(j=0;j<this.students.length-i-1;j++){
				if(this.students[j].compareTo(this.students[j+1])>0){
					st=this.students[j];
					this.students[j]=this.students[j+1];
					this.students[j+1]=st;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
